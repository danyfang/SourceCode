-- comment
{-
comment
-}

import Data.List
import System.IO

maxInt = maxBound :: Int
minInt = minBound :: Int

--Data types:
--Float Double Integer Bool Char
--Tuple

sumofNums = sum [1..1000]

addEx = 5 + 4
modEx = mod 5 4
modEx2 = 5 `mod` 4

doubleMe x = x + x

doubleSmall x = if x > 10 then x else x * 2

---------------- function definition using pattern matching
lucky :: (Integral a) => a -> String
lucky 7 = "Lucky number it is"
lucky x = "Out of luck, pal"

factorial :: (Integral a) => a -> a
factorial 0 = 1
factorial n = n * factorial (n-1)


-- our own head function
head' :: [a] -> a
head' [] = error "Cant call head on an empty list"
head' (x:_) = x

---------------- function definition using guards 
bmiTell :: (RealFloat a) => a -> String
bmiTell bmi
    | bmi <= 18.5 = "You are underweight"
    | bmi <= 25.0 = "You are supposedly normal"
    | bmi <= 35.0 = "You are fat"
    | otherwise = "You are a whale"
