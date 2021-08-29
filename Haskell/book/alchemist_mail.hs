address name loc = nameTxt ++ " - " ++ loc
    where nameTxt = (fst name) ++ " " ++ (snd name)

getLoc loc = case loc of
    "ny" -> ny
    "sf" -> sf
    "reno" -> reno
    _ -> (\name -> (fst name) ++ " " ++ (snd name))

sf name = if last < "L"
          then nameTxt ++ " - PO Box 1234 - San Francisco, CA, 94111"
          else nameTxt ++ " - PO Box 1010 - San Francisco, CA, 94109"
    where last = snd name
          nameTxt = (fst name) ++ " " ++ (snd name)

ny name = nameTxt ++ ": PO Box 789 - New York, NY, 10013"
    where nameTxt = (fst name) ++ " " ++ (snd name)

reno name = nameTxt ++ ": PO Box 456 - Reno, NV, 89523"
    where nameTxt = (fst name) ++ " " ++ (snd name)