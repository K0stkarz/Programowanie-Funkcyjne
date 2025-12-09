{-# LANGUAGE OverloadedStrings #-}

import qualified Web.Scotty as Scotty
import Data.Aeson (object, (.=))

main :: IO ()
main = Scotty.scotty 3000 $ do

    Scotty.get "/" $ do
            Scotty.text "Hello World"
      
