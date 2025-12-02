{-# LANGUAGE OverloadedStrings #-}
{-# LANGUAGE DeriveGeneric #-}

import Web.Scotty
import Data.Aeson (FromJSON, ToJSON, Value(Null, Number), object, (.=))
import Data.Text (Text)
import GHC.Generics

data E1 = E1 { 
    list :: [Value], 
    order :: Text 
    } deriving (Show, Generic)

instance FromJSON E1
instance ToJSON E1

isSorted :: [Value] -> Text -> Bool
isSorted lst ord = case ord of 
    "asc"  -> and $ zipWith (<=) lst (tail lst)
    "desc" -> and $ zipWith (>=) lst (tail lst)
    _      -> False

main :: IO ()
main = scotty 3000 $ do
    
    get "/" $ do
        text "Hello World"

    post "/is-sorted" $ do
        e1 <- jsonData :: ActionM E1
        let lst = list e1
        let ord = order e1
        let result = isSorted lst ord
        json $ object ["result" .= result]