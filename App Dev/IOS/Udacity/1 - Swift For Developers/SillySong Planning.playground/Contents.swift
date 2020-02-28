import Cocoa
import Foundation

func shortNameFromName(name: String) -> String {
    var lowerCaseName = name.lowercased().folding(options: .diacriticInsensitive, locale: .current)
    let vowelSet = CharacterSet(charactersIn: "aeiou")
    
    if !vowelSet.contains(lowerCaseName.unicodeScalars[lowerCaseName.startIndex]) {
        lowerCaseName.remove(at: lowerCaseName.startIndex)
    }
    
    return lowerCaseName
}

let bananaFanaTemplate = [
"<FULL_NAME>, <FULL_NAME>, Bo B<SHORT_NAME>",
"Banana Fana Fo F<SHORT_NAME>",
"Me My Mo M<SHORT_NAME>",
"<FULL_NAME>"].joined(separator: "\n")

func lyricsForName(lyricsTemplate: String, fullName: String) -> String {
    return lyricsTemplate.replacingOccurrences(of: "<FULL_NAME>", with: fullName)
        .replacingOccurrences(of: "<SHORT_NAME>", with: shortNameFromName(name: fullName))
}

lyricsForName(lyricsTemplate: bananaFanaTemplate, fullName: "Rohan")
