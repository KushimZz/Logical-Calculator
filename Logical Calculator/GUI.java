import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame implements ActionListener{
    String memory ="";
    String currentOperation ="";
    String radix = "";

    //swing arayüz tanımlamaları
    JFrame frame;
    JLabel label = new JLabel();
    JTextField textField = new JTextField();
    JTextField memoryTextField = new JTextField();
    JRadioButton binaryButton;

    JRadioButton decimalButton;
    JRadioButton hexadecimalButton;
    JButton buttonZero;
    JButton buttonOne;
    JButton buttonTwo;
    JButton buttonThree;
    JButton buttonFour;
    JButton buttonFive;
    JButton buttonSix;
    JButton buttonSeven;
    JButton buttonEight;
    JButton buttonNine;
    JButton buttonComa;
    JButton buttonClear;
    JButton buttonDelete;
    JButton buttonEqualto;
    JButton buttonMulti;
    JButton buttonDiv;
    JButton buttonPlus;
    JButton buttonMinus;
    JButton buttonModulus;
    JButton buttonparantezsag;
    JButton buttonparantezsol;
    JButton buttonNegate;
    JButton buttonA;
    JButton buttonB;
    JButton buttonC;
    JButton buttonD;
    JButton buttonE;
    JButton buttonF;
    JButton buttonAnd;
    JButton buttonOr;
    JButton buttonXor;
    JButton buttonNot;
    JButton buttonShiftLeft;
    JButton buttonShiftRight;

    ArrayList<JButton> buttonValues = new ArrayList<>();



    GUI(){
        initializeFrame();
        createFrameObjects();
        setButtonValues();
        addActionListeners();
    }
    public void initializeFrame() {
        frame = new JFrame();
        frame.setTitle("Logical Calculator");
        frame.setSize(500, 450);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //A method for buttons
    private JButton setGuiButtons(int x,int y, int width, int height,Color background, Color foreground, String buttonText){
        JButton button = new JButton(buttonText);
        button.setEnabled(false);
        button.setBounds(x, y, width, height);
        button.setBackground(background);
        button.setForeground(foreground);
        return button;
    }

    //method for radio buttons
    private JRadioButton setGuiRadioButtons(int x,int y, int width, int height,Color foreground, boolean selectable, String buttonText){
        JRadioButton radioButton = new JRadioButton(buttonText);
        radioButton.setBounds(x,y,width,height);
        radioButton.setForeground(foreground);
        radioButton.setEnabled(selectable);
        return radioButton;
    }

    //for giving features to variables we created at the beginning.
    public void createFrameObjects(){

        textField.setBounds(10, 15, 470, 60);
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(textField);

        memoryTextField.setBounds(300,85,180,50);
        memoryTextField.setEditable(false);
        memoryTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(memoryTextField);

        binaryButton = this.setGuiRadioButtons(5,75,150,20,Color.black,true,"Binary");
        decimalButton = this.setGuiRadioButtons(5,95,150,20,Color.black,true,"Decimal");
        hexadecimalButton = this.setGuiRadioButtons(5,115,150,20,Color.black,true,"Hexadecimal");
        buttonDelete = this.setGuiButtons(400,140,60,40,Color.red,Color.black, "DEL");
        buttonClear = this.setGuiButtons(340,140,60,40,Color.red,Color.black,"CL");
        buttonShiftRight = this.setGuiButtons(280,140,60,40,Color.white,Color.black,">>");
        buttonShiftLeft = this.setGuiButtons(220,140,60,40,Color.white,Color.black,"<<");
        buttonDiv = this.setGuiButtons(400,180,60,40,Color.white,Color.black,"/");
        buttonModulus = this.setGuiButtons(340,180,60,40,Color.white,Color.black,"%");
        buttonparantezsag = this.setGuiButtons(280,180,60,40,Color.white,Color.black,")");
        buttonparantezsol = this.setGuiButtons(220,180,60,40,Color.white,Color.black,"(");
        buttonMulti = this.setGuiButtons(400,220,60,40,Color.white,Color.black,"x");
        buttonMinus = this.setGuiButtons(400,260,60,40,Color.white,Color.black,"-");
        buttonPlus = this.setGuiButtons(400,300,60,40,Color.white,Color.black,"+");
        buttonEqualto = this.setGuiButtons(400,340,60,40,Color.white,Color.black,"=");
        buttonNine = this.setGuiButtons(340,220,60,40,Color.white,Color.black,"9");
        buttonEight = this.setGuiButtons(280,220,60,40,Color.white,Color.black,"8");
        buttonSeven = this.setGuiButtons(220,220,60,40,Color.white,Color.black,"7");
        buttonSix = this.setGuiButtons(340,260,60,40,Color.white,Color.black,"6");
        buttonFive = this.setGuiButtons(280,260,60,40,Color.white,Color.black,"5");
        buttonFour = this.setGuiButtons(220,260,60,40,Color.white,Color.black,"4");
        buttonThree= this.setGuiButtons(340,300,60,40,Color.white,Color.black,"3");
        buttonTwo = this.setGuiButtons(280,300,60,40,Color.white,Color.black,"2");
        buttonOne = this.setGuiButtons(220,300,60,40,Color.white,Color.black,"1");
        buttonComa = this.setGuiButtons(340,340,60,40,Color.white,Color.black,",");
        buttonZero = this.setGuiButtons(280,340,60,40,Color.white,Color.black,"0");
        buttonNegate = this.setGuiButtons(220,340,60,40,Color.white,Color.black,"+/-");
        buttonA = this.setGuiButtons(160,140,60,40,Color.white,Color.black,"A");
        buttonB = this.setGuiButtons(160,180,60,40,Color.white,Color.black,"B");
        buttonC = this.setGuiButtons(160,220,60,40,Color.white,Color.black,"C");
        buttonD = this.setGuiButtons(160,260,60,40,Color.white,Color.black,"D");
        buttonE = this.setGuiButtons(160,300,60,40,Color.white,Color.black,"E");
        buttonF = this.setGuiButtons(160,340,60,40,Color.white,Color.black,"F");
        buttonAnd = this.setGuiButtons(100,220,60,40,Color.white,Color.black,"AND");
        buttonOr = this.setGuiButtons(100,260,60,40,Color.white,Color.black,"OR");
        buttonXor = this.setGuiButtons(100,300,60,40,Color.white,Color.black,"XOR");
        buttonNot = this.setGuiButtons(100,340,60,40,Color.white,Color.black,"NOT");

        frame.add(binaryButton);
        frame.add(decimalButton);
        frame.add(hexadecimalButton);
        frame.add(buttonDelete);
        frame.add(buttonClear);
        frame.add(buttonShiftRight);
        frame.add(buttonShiftLeft);
        frame.add(buttonDiv);
        frame.add(buttonModulus);
        frame.add(buttonparantezsag);
        frame.add(buttonparantezsol);
        frame.add(buttonMulti);
        frame.add(buttonMinus);
        frame.add(buttonPlus);
        frame.add(buttonEqualto);
        frame.add(buttonNine);
        frame.add(buttonEight);
        frame.add(buttonSeven);
        frame.add(buttonSix);
        frame.add(buttonFive);
        frame.add(buttonFour);
        frame.add(buttonThree);
        frame.add(buttonTwo);
        frame.add(buttonOne);
        frame.add(buttonComa);
        frame.add(buttonZero);
        frame.add(buttonNegate);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(buttonE);
        frame.add(buttonF);
        frame.add(buttonAnd);
        frame.add(buttonOr);
        frame.add(buttonXor);
        frame.add(buttonNot);
        //yalnızca birini seçebilmek için button gruba koydum
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(binaryButton);
        buttonGroup.add(decimalButton);
        buttonGroup.add(hexadecimalButton);
    }

    //for setNumberButtonBehaviors method.
    private void setButtonValues(){
        buttonValues.add(buttonZero);
        buttonValues.add(buttonOne);
        buttonValues.add(buttonTwo);
        buttonValues.add(buttonThree);
        buttonValues.add(buttonFour);
        buttonValues.add(buttonFive);
        buttonValues.add(buttonSix);
        buttonValues.add(buttonSeven);
        buttonValues.add(buttonEight);
        buttonValues.add(buttonNine);
        buttonValues.add(buttonA);
        buttonValues.add(buttonB);
        buttonValues.add(buttonC);
        buttonValues.add(buttonD);
        buttonValues.add(buttonE);
        buttonValues.add(buttonF);
    }

    //for adding action listener to every button
    public void addActionListeners() {
        binaryButton.addActionListener(this);
        decimalButton.addActionListener(this);
        hexadecimalButton.addActionListener(this);
        buttonZero.addActionListener(this);
        buttonOne.addActionListener(this);
        buttonTwo.addActionListener(this);
        buttonThree.addActionListener(this);
        buttonFour.addActionListener(this);
        buttonFive.addActionListener(this);
        buttonSix.addActionListener(this);
        buttonSeven.addActionListener(this);
        buttonEight.addActionListener(this);
        buttonNine.addActionListener(this);
        buttonComa.addActionListener(this);
        buttonMinus.addActionListener(this);
        buttonPlus.addActionListener(this);
        buttonparantezsol.addActionListener(this);
        buttonparantezsag.addActionListener(this);
        buttonModulus.addActionListener(this);
        buttonMulti.addActionListener(this);
        buttonEqualto.addActionListener(this);
        buttonShiftLeft.addActionListener(this);
        buttonShiftRight.addActionListener(this);
        buttonAnd.addActionListener(this);
        buttonOr.addActionListener(this);
        buttonNot.addActionListener(this);
        buttonXor.addActionListener(this);
        buttonA.addActionListener(this);
        buttonB.addActionListener(this);
        buttonC.addActionListener(this);
        buttonD.addActionListener(this);
        buttonE.addActionListener(this);
        buttonF.addActionListener(this);
        buttonClear.addActionListener(this);
        buttonDelete.addActionListener(this);
        buttonDiv.addActionListener(this);
        buttonNegate.addActionListener(this);
    }

    //action performed method. i used extract method for every operation to make code more readable.
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        setRadioButtonBehaviors(source);
        setClearButtonBehaviors(source);
        setDeleteButtonBehaviors(source);
        setNumberButtonBehaviors(source);
        setAndButtonBehaviors(source);
        setOrButtonBehaviors(source);
        setXorButtonBehaviors(source);
        setNotButtonBehaviors(source);
        setShiftLeftButtonBehaviors(source);
        setShiftRightButtonBehaviors(source);
        setPlusButtonBehaviors(source);
        setMinusButtonBehaviors(source);
        setMultiButtonBehaviors(source);
        setDivButtonBehaviors(source);
        setEqualsButtonBehaviors(source);
    }


//i created 3 more methods to avoid complex if else blocks. setRadioButtonBehaviors will decide in which number type we will do our operations
    private void setEqualsButtonBehaviors(Object source) {
        if (source == buttonEqualto) {
            if(this.radix.equals("DECIMAL")){
                handleDecimalOperations();
            }

            else if(this.radix.equals("HEXADECIMAL")){
                handleHexadecimalOperations();
            }

            else if(this.radix.equals("BINARY")){
                handleBinaryOperations();

            }
        }
    }

    //this method will do every operation for decimal numbers.
    private void handleDecimalOperations() {
        if(this.currentOperation.equals("AND")){
            //Integer.parseInt() converts string to integer
            int num1 = Integer.parseInt(this.memory);
            int num2 = Integer.parseInt(this.textField.getText());
            int result = num1 & num2;
            memoryTextField.setText(this.memory + " "+ this.currentOperation + " " + this.textField.getText());
            textField.setText(Integer.toString(result));
        }
        else if(this.currentOperation.equals("OR")){
            int num1 = Integer.parseInt(this.memory);
            int num2 = Integer.parseInt(this.textField.getText());
            int result = num1 | num2;
            memoryTextField.setText(this.memory + " "+ this.currentOperation + " " + this.textField.getText());
            textField.setText(Integer.toString(result));
        }
        else if(this.currentOperation.equals("XOR")){
            int num1 = Integer.parseInt(this.memory);
            int num2 = Integer.parseInt(this.textField.getText());
            int result = num1 ^ num2;
            memoryTextField.setText(this.memory + " "+ this.currentOperation + " " + this.textField.getText());
            textField.setText(Integer.toString(result));
        }
        else if(this.currentOperation.equals("NOT")){
            int num = Integer.parseInt(this.memory);
            int result = ~num;
            memoryTextField.setText(this.currentOperation + " " + this.memory);
            textField.setText(Integer.toString(result));
        }
        else if(this.currentOperation.equals("+")){
            int num1 = Integer.parseInt(this.memory);
            int num2 = Integer.parseInt(this.textField.getText());
            int result = num1 + num2;
            memoryTextField.setText(this.memory + " "+ this.currentOperation + " " + this.textField.getText());
            textField.setText(Integer.toString(result));
        }
        else if(this.currentOperation.equals("-")){
            int num1 = Integer.parseInt(this.memory);
            int num2 = Integer.parseInt(this.textField.getText());
            int result = num1 - num2;
            memoryTextField.setText(this.memory + " "+ this.currentOperation + " " + this.textField.getText());
            textField.setText(Integer.toString(result));
        }
        else if(this.currentOperation.equals("x")){
            int num1 = Integer.parseInt(this.memory);
            int num2 = Integer.parseInt(this.textField.getText());
            int result = num1 * num2;
            memoryTextField.setText(this.memory + " "+ this.currentOperation + " " + this.textField.getText());
            textField.setText(Integer.toString(result));
        }
        else if(this.currentOperation.equals("/")){
            int num1 = Integer.parseInt(this.memory);
            int num2 = Integer.parseInt(this.textField.getText());
            int result = num1 / num2;
            memoryTextField.setText(this.memory + " "+ this.currentOperation + " " + this.textField.getText());
            textField.setText(Integer.toString(result));
        }
        else if(this.currentOperation.equals("<<")){
            int num1 = Integer.parseInt(this.memory);
            int num2 = Integer.parseInt(this.textField.getText());
            int result = num1 << num2;
            memoryTextField.setText(this.memory + " "+ this.currentOperation + " " + this.textField.getText());
            textField.setText(Integer.toString(result));
        }
        else if(this.currentOperation.equals(">>")){
            int num1 = Integer.parseInt(this.memory);
            int num2 = Integer.parseInt(this.textField.getText());
            int result = num1 >> num2;
            memoryTextField.setText(this.memory + " "+ this.currentOperation + " " + this.textField.getText());
            textField.setText(Integer.toString(result));
        }

    }

    private void handleHexadecimalOperations() {
        if(this.currentOperation.equals("AND")){
            //Long.parseLong() turns String into long
            long num1 = Long.parseLong(this.memory,16);
            long num2 = Long.parseLong(this.textField.getText(),16);
            long result = num1 & num2;
            memoryTextField.setText(this.memory + " "+ this.currentOperation + " " + this.textField.getText());
            textField.setText(Long.toHexString(result));
        }
        else if(this.currentOperation.equals("OR")){
            long num1 = Long.parseLong(this.memory,16);
            long num2 = Long.parseLong(this.textField.getText(),16);
            long result = num1 | num2;
            memoryTextField.setText(this.memory + " "+ this.currentOperation + " " + this.textField.getText());
            textField.setText(Long.toHexString(result));
        }
        else if(this.currentOperation.equals("XOR")){
            long num1 = Long.parseLong(this.memory,16);
            long num2 = Long.parseLong(this.textField.getText(),16);
            long result = num1 ^ num2;
            memoryTextField.setText(this.memory + " "+ this.currentOperation + " " + this.textField.getText());
            textField.setText(Long.toHexString(result));
        }
        else if(this.currentOperation.equals("NOT")){
            long num = Long.parseLong(this.memory,16);
            long result = ~num;
            memoryTextField.setText(this.currentOperation + " " + this.memory);
            textField.setText(Long.toHexString(result));
        }
        else if(this.currentOperation.equals("+")){
            long num1 = Long.parseLong(this.memory,16);
            long num2 = Long.parseLong(this.textField.getText(),16);
            long result = num1 + num2;
            memoryTextField.setText(this.memory + " "+ this.currentOperation + " " + this.textField.getText());
            textField.setText(Long.toHexString(result));
        }
        else if(this.currentOperation.equals("-")){
            long num1 = Long.parseLong(this.memory,16);
            long num2 = Long.parseLong(this.textField.getText(),16);
            long result = num1 - num2;
            memoryTextField.setText(this.memory + " "+ this.currentOperation + " " + this.textField.getText());
            textField.setText(Long.toHexString(result));
        }
        else if(this.currentOperation.equals("x")){
            long num1 = Long.parseLong(this.memory,16);
            long num2 = Long.parseLong(this.textField.getText(),16);
            long result = num1 * num2;
            memoryTextField.setText(this.memory + " "+ this.currentOperation + " " + this.textField.getText());
            textField.setText(Long.toHexString(result));
        }
        else if(this.currentOperation.equals("/")){
            long num1 = Long.parseLong(this.memory,16);
            long num2 = Long.parseLong(this.textField.getText(),16);
            long result = num1 / num2;
            memoryTextField.setText(this.memory + " "+ this.currentOperation + " " + this.textField.getText());
            textField.setText(Long.toHexString(result));
        }
        else if(this.currentOperation.equals("<<")){
            long num1 = Long.parseLong(this.memory,16);
            long num2 = Long.parseLong(this.textField.getText(),16);
            long result = num1 << num2;
            memoryTextField.setText(this.memory + " "+ this.currentOperation + " " + this.textField.getText());
            textField.setText(Long.toHexString(result));
        }
        else if(this.currentOperation.equals(">>")){
            long num1 = Long.parseLong(this.memory,16);
            long num2 = Long.parseLong(this.textField.getText(),16);
            long result = num1 >> num2;
            memoryTextField.setText(this.memory + " "+ this.currentOperation + " " + this.textField.getText());
            textField.setText(Long.toHexString(result));
        }
    }

    private void handleBinaryOperations() {
        if(this.currentOperation.equals("AND")){
            int num1 = Integer.parseInt(this.memory,2);
            int num2 = Integer.parseInt(this.textField.getText(),2);
            int result = num1 & num2;
            memoryTextField.setText(this.memory + " "+ this.currentOperation + " " + this.textField.getText());
            textField.setText(Integer.toBinaryString(result));
        }
        else if(this.currentOperation.equals("OR")){
            int num1 = Integer.parseInt(this.memory,2);
            int num2 = Integer.parseInt(this.textField.getText(),2);
            int result = num1 | num2;
            memoryTextField.setText(this.memory + " "+ this.currentOperation + " " + this.textField.getText());
            textField.setText(Integer.toBinaryString(result));
        }
        else if(this.currentOperation.equals("XOR")){
            int num1 = Integer.parseInt(this.memory,2);
            int num2 = Integer.parseInt(this.textField.getText(),2);
            int result = num1 ^ num2;
            memoryTextField.setText(this.memory + " "+ this.currentOperation + " " + this.textField.getText());
            textField.setText(Integer.toBinaryString(result));
        }
        else if(this.currentOperation.equals("NOT")){
            int num = Integer.parseInt(this.textField.getText(),2);
            int result = ~num;
            memoryTextField.setText(this.currentOperation + " " + this.memory);
            textField.setText(Integer.toBinaryString(result));
        }
        else if(this.currentOperation.equals("+")){
            int num1 = Integer.parseInt(this.memory,2);
            int num2 = Integer.parseInt(this.textField.getText(),2);
            int result = num1 + num2;
            memoryTextField.setText(this.memory + " "+ this.currentOperation + " " + this.textField.getText());
            textField.setText(Integer.toBinaryString(result));
        }
        else if(this.currentOperation.equals("-")){
            int num1 = Integer.parseInt(this.memory,2);
            int num2 = Integer.parseInt(this.textField.getText(),2);
            int result = num1 - num2;
            memoryTextField.setText(this.memory + " "+ this.currentOperation + " " + this.textField.getText());
            textField.setText(Integer.toBinaryString(result));
        }
        else if(this.currentOperation.equals("x")){
            int num1 = Integer.parseInt(this.memory,2);
            int num2 = Integer.parseInt(this.textField.getText(),2);
            int result = num1 * num2;
            memoryTextField.setText(this.memory + " "+ this.currentOperation + " " + this.textField.getText());
            textField.setText(Integer.toBinaryString(result));
        }
        else if(this.currentOperation.equals("/")){
            int num1 = Integer.parseInt(this.memory,2);
            int num2 = Integer.parseInt(this.textField.getText(),2);
            int result = num1 / num2;
            memoryTextField.setText(this.memory + " "+ this.currentOperation + " " + this.textField.getText());
            textField.setText(Integer.toBinaryString(result));
        }
        else if(this.currentOperation.equals("<<")){
            int num1 = Integer.parseInt(this.memory,2);
            int num2 = Integer.parseInt(this.textField.getText(),2);
            int result = num1 << num2;
            memoryTextField.setText(this.memory + " "+ this.currentOperation + " " + this.textField.getText());
            textField.setText(Integer.toBinaryString(result));
        }
        else if(this.currentOperation.equals(">>")){
            int num1 = Integer.parseInt(this.memory,2);
            int num2 = Integer.parseInt(this.textField.getText(),2);
            int result = num1 >> num2;
            memoryTextField.setText(this.memory + " "+ this.currentOperation + " " + this.textField.getText());
            textField.setText(Integer.toBinaryString(result));
        }
    }



    //for setting operator
    private void setOperation(String op) {
        String currentText = textField.getText();
        if(currentText.length()>0){
            this.memory = currentText;
            this.currentOperation=op;
            textField.setText("");
            this.refreshMemoryTextField();
        }
    }

    private void setDivButtonBehaviors(Object source) {
        if(source == buttonDiv){
            setOperation("/");
        }
    }

    private void setMultiButtonBehaviors(Object source) {
        if(source == buttonMulti){
            setOperation("x");
        }
    }

    private void setMinusButtonBehaviors(Object source) {
        if(source == buttonMinus){
            setOperation("-");
        }
    }

    private void setPlusButtonBehaviors(Object source) {
        if (source == buttonPlus) {
            setOperation("+");
        }
    }

    private void setNotButtonBehaviors(Object source) {
        if (source == buttonNot) {
            setOperation("NOT");
        }
    }

    private void setXorButtonBehaviors(Object source) {
        if (source == buttonXor) {
            setOperation("XOR");
        }
    }

    private void setOrButtonBehaviors(Object source) {
        if (source == buttonOr) {
            setOperation("OR");
        }
    }

    private void setAndButtonBehaviors(Object source) {
        if (source == buttonAnd) {
            setOperation("AND");
        }
    }

    private void setShiftLeftButtonBehaviors(Object source) {
        if(source == buttonShiftLeft){
            setOperation("<<");
        }
    }

    private void setShiftRightButtonBehaviors(Object source) {
        if(source == buttonShiftRight){
            setOperation(">>");
        }
    }


    //for adding the buttons from 0 to 9 and A to F to the textField
    private void setNumberButtonBehaviors(Object source) {
        for(JButton buttonValue: this.buttonValues){
            if(source == buttonValue){
                String currentText = textField.getText();
                String buttonText = buttonValue.getText().trim();
                textField.setText(currentText+buttonText);
            }
        }
    }

    //for delete button
    private void setDeleteButtonBehaviors(Object source) {
        if (source == buttonDelete) {
            int length = textField.getText().length();
            int number = length - 1;

            if (length > 0) {
                StringBuilder back = new StringBuilder(textField.getText());
                back.deleteCharAt(number);
                textField.setText(back.toString());

            }
            if (textField.getText().endsWith("")) {
                label.setText("");
            }
        }
    }

    //for updating memoryTextField
    private void refreshMemoryTextField(){
        this.memoryTextField.setText(this.memory + " " + this.currentOperation);
    }
    private void setClearButtonBehaviors(Object source) {
        if (source == this.buttonClear) {
            this.label.setText("");
            this.textField.setText("");
            this.memory ="";
            this.currentOperation="";
            this.refreshMemoryTextField();
        }
    }

    private void setRadioButtonBehaviors(Object source) {
        if (source == this.binaryButton) {
            this.disableButtonsForBinary();
            this.radix="BINARY";
        } else if (source == this.decimalButton) {
            this.disableButtonsForDecimal();
            this.radix="DECIMAL";
        } else if (source == this.hexadecimalButton) {
            this.disableButtonsForHexadecimal();
            this.radix="HEXADECIMAL";
        }
    }
    private void disableButtonsForBinary() {
        this.binaryButton.setEnabled(true);
        this.decimalButton.setEnabled(true);
        this.hexadecimalButton.setEnabled(true);
        this.buttonClear.setEnabled(true);
        this.buttonDelete.setEnabled(true);
        this.buttonDiv.setEnabled(true);
        this.buttonparantezsag.setEnabled(false);
        this.buttonparantezsol.setEnabled(false);
        this.buttonModulus.setEnabled(false);
        this.buttonMinus.setEnabled(true);
        this.buttonSeven.setEnabled(false);
        this.buttonEight.setEnabled(false);
        this.buttonNine.setEnabled(false);
        this.buttonMulti.setEnabled(true);
        this.buttonFour.setEnabled(false);
        this.buttonFive.setEnabled(false);
        this.buttonSix.setEnabled(false);
        this.buttonPlus.setEnabled(true);
        this.buttonOne.setEnabled(true);
        this.buttonTwo.setEnabled(false);
        this.buttonThree.setEnabled(false);
        this.buttonEqualto.setEnabled(true);
        this.buttonZero.setEnabled(true);
        this.buttonComa.setEnabled(true);
        this.buttonA.setEnabled(false);
        this.buttonB.setEnabled(false);
        this.buttonC.setEnabled(false);
        this.buttonD.setEnabled(false);
        this.buttonE.setEnabled(false);
        this.buttonF.setEnabled(false);
        this.buttonNegate.setEnabled(false);
        this.buttonShiftLeft.setEnabled(true);
        this.buttonShiftRight.setEnabled(true);
        this.buttonAnd.setEnabled(true);
        this.buttonNot.setEnabled(true);
        this.buttonOr.setEnabled(true);
        this.buttonXor.setEnabled(true);
    }
    private void disableButtonsForDecimal() {
        this.buttonAnd.setEnabled(true);
        this.buttonNot.setEnabled(true);
        this.buttonOr.setEnabled(true);
        this.buttonXor.setEnabled(true);
        this.binaryButton.setEnabled(true);
        this.decimalButton.setEnabled(true);
        this.hexadecimalButton.setEnabled(true);
        this.buttonClear.setEnabled(true);
        this.buttonDelete.setEnabled(true);
        this.buttonDiv.setEnabled(true);
        this.buttonparantezsag.setEnabled(false);
        this.buttonparantezsol.setEnabled(false);
        this.buttonModulus.setEnabled(false);
        this.buttonMinus.setEnabled(true);
        this.buttonSeven.setEnabled(true);
        this.buttonEight.setEnabled(true);
        this.buttonNine.setEnabled(true);
        this.buttonMulti.setEnabled(true);
        this.buttonFour.setEnabled(true);
        this.buttonFive.setEnabled(true);
        this.buttonSix.setEnabled(true);
        this.buttonPlus.setEnabled(true);
        this.buttonOne.setEnabled(true);
        this.buttonTwo.setEnabled(true);
        this.buttonThree.setEnabled(true);
        this.buttonEqualto.setEnabled(true);
        this.buttonZero.setEnabled(true);
        this.buttonComa.setEnabled(true);
        this.buttonA.setEnabled(false);
        this.buttonB.setEnabled(false);
        this.buttonC.setEnabled(false);
        this.buttonD.setEnabled(false);
        this.buttonE.setEnabled(false);
        this.buttonF.setEnabled(false);
        this.buttonNegate.setEnabled(false);
        this.buttonShiftLeft.setEnabled(true);
        this.buttonShiftRight.setEnabled(true);
    }
    private void disableButtonsForHexadecimal() {
        this.binaryButton.setEnabled(true);
        this.decimalButton.setEnabled(true);
        this.hexadecimalButton.setEnabled(true);
        this.buttonClear.setEnabled(true);
        this.buttonDelete.setEnabled(true);
        this.buttonDiv.setEnabled(true);
        this.buttonAnd.setEnabled(true);
        this.buttonNot.setEnabled(true);
        this.buttonOr.setEnabled(true);
        this.buttonXor.setEnabled(true);
        this.buttonparantezsag.setEnabled(false);
        this.buttonparantezsol.setEnabled(false);
        this.buttonModulus.setEnabled(false);
        this.buttonMinus.setEnabled(true);
        this.buttonSeven.setEnabled(true);
        this.buttonEight.setEnabled(true);
        this.buttonNine.setEnabled(true);
        this.buttonMulti.setEnabled(true);
        this.buttonFour.setEnabled(true);
        this.buttonFive.setEnabled(true);
        this.buttonSix.setEnabled(true);
        this.buttonPlus.setEnabled(true);
        this.buttonOne.setEnabled(true);
        this.buttonTwo.setEnabled(true);
        this.buttonThree.setEnabled(true);
        this.buttonEqualto.setEnabled(true);
        this.buttonZero.setEnabled(true);
        this.buttonComa.setEnabled(true);
        this.buttonA.setEnabled(true);
        this.buttonB.setEnabled(true);
        this.buttonC.setEnabled(true);
        this.buttonD.setEnabled(true);
        this.buttonE.setEnabled(true);
        this.buttonF.setEnabled(true);
        this.buttonNegate.setEnabled(false);
        this.buttonShiftLeft.setEnabled(true);
        this.buttonShiftRight.setEnabled(true);
    }

}
