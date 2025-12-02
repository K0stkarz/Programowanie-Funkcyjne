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

data E2 = E2 {
    list1 :: [Value],
    list2 :: [Value],
    list3 :: [Value]
    } deriving (Show, Generic)

instance FromJSON E2
instance ToJSON E2

data E3 = E3 {
    listA :: [Value],
    element :: Value
    } deriving (Show, Generic)

instance FromJSON E3
instance ToJSON E3

isSorted :: [Value] -> Text -> Bool
isSorted lst ord = case ord of 
    "asc"  -> and $ zipWith (<=) lst (tail lst)
    "desc" -> and $ zipWith (>=) lst (tail lst)
    _      -> False

sumXY :: Value -> Value -> Value
sumXY (Number x) (Number y) = Number (x + y)
sumXY _ _ = Null

sumLists :: [Value] -> [Value] -> [Value]
sumLists l1 l2 = zipWith (sumXY) (extList l1) (extList l2)
    where
        maxLength = max (length l1) (length l2)
        extList l = l ++ replicate (maxLength - length l) (Number 0)
        
setHead :: [Value] -> Value -> [Value]
setHead l e = e : l    

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
    
    post "/sum-lists" $ do
        e2 <- jsonData :: ActionM E2
        let l1 = list1 e2
        let l2 = list2 e2
        let l3 = list3 e2
        let result = sumLists l1 (sumLists l2 l3)
        json $ object ["result" .= result]

    post "/set-head" $ do
        e3 <- jsonData :: ActionM E3
        let lst = listA e3
        let e = element e3
        let result = setHead lst e
        json $ object ["result" .= result]