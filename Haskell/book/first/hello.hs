main = do
    print (quadratic 1 (-6) 9)

sumSquareOrSquareSum x y = if sumSquare > squareSum
    then sumSquare
    else squareSum
    where sumSquare = x^2 + y^2
          squareSum = (x + y) ^ 2

quadratic a b c = let discriminant = b^2 - 4 * a * c
                      sol1 = (-b + sqrt(discriminant)) / (2 * a)
                      sol2 = (-b - sqrt(discriminant)) / (2 * a)
                  in
                      if discriminant > 0
                      then sol1
                      else if discriminant == 0
                      then sol2
                      else -1