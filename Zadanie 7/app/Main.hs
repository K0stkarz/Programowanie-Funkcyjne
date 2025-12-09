{-# LANGUAGE OverloadedStrings #-}

import qualified Web.Scotty as Scotty
import Data.Aeson (object, (.=))
import Control.Monad.State
import Data.IORef

type Rand a = State Int a

mConstant :: Int
mConstant = 2147483648  -- 2^31

nextRand :: Rand Int
nextRand = do
  seed <- get
  let a   = 1103515245
      c   = 12345
      m   = mConstant
      seed' = (a * seed + c) `mod` m
  put seed'
  return seed'

nextRandDouble :: Rand Double
nextRandDouble = do
  r <- nextRand
  return $ fromIntegral r / fromIntegral mConstant

runWithState :: IORef Int -> Rand a -> IO a
runWithState ref action = do
    oldSeed <- readIORef ref
    let (result, newSeed) = runState action oldSeed
    writeIORef ref newSeed
    return result

main :: IO ()
main = do 
    globalSeed <- newIORef 42

    Scotty.scotty 3000 $ do
    
        Scotty.get "/" $ do
            Scotty.text "Hello World"

        Scotty.get "/get-random-0-to-maxInt" $ do 
            xs <- liftIO $ runWithState globalSeed nextRand
            Scotty.json $ object ["result" .= xs]

        Scotty.get "/get-random-0-to-1" $ do 
            xs <- liftIO $ runWithState globalSeed nextRandDouble
            Scotty.json $ object ["result" .= xs]