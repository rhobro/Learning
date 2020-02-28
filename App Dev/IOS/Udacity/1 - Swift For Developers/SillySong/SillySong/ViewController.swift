//
//  ViewController.swift
//  SillySong
//
//  Created by Rohan Mathew on 06/10/2019.
//  Copyright © 2019 NeuroByte Tech. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    // Member Fields
    // The TextField in which the user types their name.
    @IBOutlet weak var nameField: UITextField!
    // The TextView in which the lyrics show
    @IBOutlet weak var lyricsView: UITextView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        nameField.delegate = self
        nameField.returnKeyType = UIReturnKeyType.done
    }

    @IBAction func reset(_ sender: Any) {
    }
    
    @IBAction func displayLyrics(_ sender: Any) {
        let bananaFanaTemplate = [
        "<FULL_NAME>, <FULL_NAME>, Bo B<SHORT_NAME>",
        "Banana Fana Fo F<SHORT_NAME>",
        "Me My Mo M<SHORT_NAME>",
        "<FULL_NAME>"].joined(separator: "\n")
        
        let userName = nameField.text?.lowercased()
        if userName?.isEmpty == false {
            let song = lyricsForName(lyricsTemplate: bananaFanaTemplate, fullName: userName ?? "rohan")
            lyricsView.text = song
        }
    }
    
    @IBAction func capitaliseFirstLetter(_ sender: Any) {
        var text = nameField.text?.trimmingCharacters(in: .whitespacesAndNewlines)
        text = text?.lowercased().first?.uppercased()
    }
    
    func shortNameFromName(name: String) -> String {
        var lowerCaseName = name.lowercased().folding(options: .diacriticInsensitive, locale: .current)
        let vowelSet = CharacterSet(charactersIn: "aeiou")
        
        if !vowelSet.contains(lowerCaseName.unicodeScalars[lowerCaseName.startIndex]) {
            lowerCaseName.remove(at: lowerCaseName.startIndex)
        }
        
        return lowerCaseName
    }
    
    func lyricsForName(lyricsTemplate: String, fullName: String) -> String {
        return lyricsTemplate.replacingOccurrences(of: "<FULL_NAME>", with: fullName)
            .replacingOccurrences(of: "<SHORT_NAME>", with: shortNameFromName(name: fullName))
    }
}

extension ViewController: UITextFieldDelegate {
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return false
    }
}
