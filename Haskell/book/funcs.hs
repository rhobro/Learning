largestSquare x y = if sumSq > sqSum
                then sumSq
                else sqSum
    where sumSq = x^2 + y^2
          sqSum = (x + y)^2

overwrite x = let x = 2
              in
                    let x = 3
                    in
                          let x = 4
                          in
                                x

overwriteLmb = (\x ->
      (\x ->
            (\x -> x) 4
            ) 3
      ) 2