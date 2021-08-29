inc n = n + 1
double n = n * 2
square n = n^2

ifEven func n = if even n
                then func n
                else n

ifEvenInc = ifEven inc
ifEvenDouble = ifEven double
ifEvenSquare = ifEven square