{-# LANGUAGE OverloadedStrings #-}

import qualified Web.Scotty as Scotty
import Data.Aeson (object, (.=))
import Control.Monad.State
import Data.IORef

type Rand a = State Int a

nextRand :: Rand Int
nextRand = do
  seed <- get
  let a   = 1103515245
      c   = 12345
      m   = 2147483648      -- 2^31
      seed' = (a * seed + c) `mod` m
  put seed'
  return seed'

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