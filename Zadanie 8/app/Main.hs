{-# LANGUAGE OverloadedStrings #-}
{-# LANGUAGE DeriveGeneric #-}

import Web.Scotty
import Data.Aeson (FromJSON, ToJSON, object, (.=))
import Data.Text (Text)
import GHC.Generics

data E1 = E1 {
    x :: Double,
    y :: Double,
    sign :: Text
} deriving (Show, Generic)

instance FromJSON E1
instance ToJSON E1

calc :: E1 -> Double
calc e
    | sign e == "+" = x e + y e
    | sign e == "-" = x e - y e
    | otherwise = 0.0

main :: IO ()
main = scotty 3000 $ do

        get "/" $ do
            text "Hello World"

        post "/fmap" $ do
            result <- calc <$> jsonData
            json $ object ["result" .= result]