/**
 *
 *  @author Głodowski Michał S10552
 *
 */
package zad2;

import static javax.swing.JOptionPane.*

// Define scheme with empty map initialisation with default values of '0' do avoid NullPointerException when adding products' prices.
products = [ : ].withDefault { 0 }

// Instruction for pop up.
def instructionsH = "PODAJ PRODUKT W FORMIE:\n \t \t  [pozycja = cena] \n \n \t "
def iRule0 = "Zasady: \n \n \t "
def iRule1 = "- Nie podanie wartości podowouje zatrzymanie programu. \n \n \t "
def iRule2 = "- Podanie kilkukrotnie pozycji o tej samej nazwie skutkuje dodaniem wartości do istniejącej już wartości w tym samym elemencie (suma). \n \n \t  "
def iRule3 = "- Wciśnięcie <Cancel> skutkuje wyswietleniem podsumowania całości.\n \n "

// Default initial value of pop up.
def initV = "chleb = 3.99"

while (getProduct = showInputDialog(instructionsH + iRule0 + iRule1 + iRule2 + iRule3, initV))
	if (getProduct =~ /^(?i)[a-zA-Z ]+ \= +\d+\.*\d*$/) {
		// Split both product and it's price so they can be mapped.
		def formatProduct = getProduct.tokenize(" = ")
		// Check in console what value was passed. Aka show new product-price pair during adding.
		println formatProduct
		// Elements before ' = ' are names of the products. In addition those elements are secured against letters' case mistakes.
		def productName = formatProduct[0].toLowerCase()
		// Elements after ' = ' are their prices.
		def productPrice = formatProduct[1].toBigDecimal()
		// Products with the same name will have their costs added and new products will be added as new.
		products[productName] += productPrice

	} else {
		// If user put his data in incorrect format display information about it.
		showMessageDialog(null, "Format danych niezgodny ze wzorcem! \n \n Spróbuj ponownie.", "", 0)
	}

//Sort whole map by product names in alphabetical order.
def sortedByNames = products.sort { it.key }
// Add all value of all products to give user an idea how much there is to pay for their shopping list.
def overallPrice = products.values().sum()
// Check in console what value was passed.
println "Razem: " + overallPrice

// Pop out final result for the user. Should shopping list be empty give user different message.
if (sortedByNames.isEmpty() == false) {
	def something = showMessageDialog(null, "1) Lista zakupów i koszty poszczególnych produktów: (pozycja:cena) \n \t \t " + sortedByNames + "\n \n 2) Razem do zapłaty: \n \t \t " + overallPrice)
} else {
	def nothing = showMessageDialog(null, "Nie podano żadnych produktów.", "", 0)
}
