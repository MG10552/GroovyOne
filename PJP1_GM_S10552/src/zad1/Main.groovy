/**
 *
 *  @author Głodowski Michał‚ S10552
 *
 */
package zad1;

import static javax.swing.JOptionPane.*

// Define scheme how program should map each fragment of a number to digits as string.
def fragToWord = ["0": "zero", 
				  "1": "jeden", 
				  "2": "dwa", 
				  "3": "trzy", 
				  "4": "cztery", 
				  "5": "pięć", 
				  "6": "sześć", 
				  "7": "siedem", 
				  "8": "osiem", 
				  "9": "dziewięć"]

// Instruction for pop up.
def instructionsH = "PODAJ LICZBĘ DO WIWISEKCJI:\n \n "
	def iRule0 = "Zasady:\n \t \t "
	def iRule1 = "- Wymagane jest podanie liczby całkowitej w postaci arabskiej.\n \t \t "
	def iRule2 = "- Wynik zostanie wyświetlony po zatwierdzeniu liczby.\n \t \t  "
	def iRule3 = "- Niepodanie żadnej wartości skutkuje zatrzymaniem programu. \n \n "

// Default initial value of pop up.									
def initV = "147"

// Pop out window demanding number for vivisection from user.
while (getNumber = showInputDialog(instructionsH + iRule0 + iRule1 + iRule2 + iRule3, initV))
		if (getNumber.isNumber() == true && getNumber =~ /\d/) {
			// Local storage for fragments.
			def transformationBuffer = []
			// For number given by user alter pieces (digits) to strings, then gather all pieces in storage for later.
			getNumber.each {
				transformationBuffer << fragToWord[it as String]
			}
			// Collect all piece into single result where elements are separated by " - " expression.
			def result = transformationBuffer.join(" - ")
			// Pop out final result for the user.
			def endGoal = showMessageDialog(null, "PODANO: \n " + getNumber + "\n \n " + "OTRZYMANO: \n " + result + "\n \n ")
			// Check in console what value was passed.
			println getNumber
			
		} else {
			// If user type values that are not numbers in Arabic notation program cannot work.
			showMessageDialog(null, "Podane '" + getNumber + "' nie jest liczbą całkowitą wyrażoną w postaci arabskiej!\n \n Spróbuj ponownie.", "", 0)
			// Check in console what value was passed.
			println getNumber
			} 
	