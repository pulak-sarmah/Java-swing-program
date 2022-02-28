
# Java-swing assignments

Some basic java-swing programs.

## Questions


#### Lab-1


Design a GUI application for temperature conversion program:

When the user enters the temperature in the text field adjacent to the label Temp in Celsius and presses the Enter key, the program displays the equivalent temperature in the text field adjacent to the label Temp in Fahrenheit. 
Similarly, when the user enters the temperature in Fahrenheit and presses the Enter key, the program displays the equivalent temperature in Celsius.

Input: Temperature in Fahrenheit or Celsius
Output: Temperature in Celsius if the input is Fahrenheit; the temperature in Fahrenheit if the input is Celsius
Required formulas:

celsius = (5.0 / 9.0) * (fahrenheit – 32)
farenheit= 5.0 / 9.0 * (98.6 – 32) = 37.00

Design Steps:


1.	Have a listener in each text field.
2.	Register an event handler with each text field.
3.	Let each event handler registered with a text field do the following:

a)Get the data from the text field once the user presses Enter.
b)Apply the corresponding formula to perform the conversion.
c)Set the value of the other text field.


#### Lab-2 


1. Design an interface for a 16-button integer calculator that supports addition, subtraction, multiplication, and division. 


2. Implement the interface so that the label of the button is displayed in the calculator’s display—that is, it doesn’t do the math.

3. Next step: make it a working calculator


#### Lab-3

1. Change the program  in the Convertor (code enclosed in repository) so that we can use it for conversion of Celsius to Fahrenheit and vice versa. 

2. Change in the UI:

    Replace the “Convert” button in the control panel by two buttons – “Celsius” and “Fahrenheit”

    Proper care must be taken to take care of max and min value i.e. ( 0 – 100 for Celsius and 32 – 212 for Fahrenheit, any value beyond must be trapped by exception and display appropriate message at the display area)





