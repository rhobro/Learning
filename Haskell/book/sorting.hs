import Data.List

main = do
    print (sortBy byForename names)
    print (sortBy bySurname names)

names = [
    ("Ian", "Curtis"),
    ("Bernard", "Sumner"),
    ("Peter", "Hook"),
    ("Stephen", "Morris")]

byForename n1 n2 = if f1 > f2
                   then GT
                   else if f1 < f2
                       then LT
                       else EQ
                   
    where f1 = fst n1
          f2 = fst n2

bySurname n1 n2 = if s1 > s2
                   then GT
                   else if s1 < s2
                       then LT
                       else EQ
                   
    where s1 = snd n1
          s2 = snd n2