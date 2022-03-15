<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello</h1>
<h1>Java Quiz</h1><br>
    Q1. Number of primitive data types in Java are? <br>
    <input type="radio" name="question1">6<br>
    <input type="radio" name="question1">7<br>
    <input type="radio" name="question1" id="correct1">8<br>
    <input type="radio" name="question1">9<br>

    Q2. What is the size of float and double in java?<br>    
    <input type="radio" name="question2" id="correct2"> 32 AND 64<br>
    <input type="radio" name="question2"> 32 AND 32<br>
    <input type="radio" name="question2"> 64 AND 64<br>
    <input type="radio" name="question2"> 64 AND 32<br>

    Q3.  Which of the following option leads to the portability and security of Java?<br>
    <input type="radio" name="question3" id="correct3">Bytecode is executed by JVM<br>
    <input type="radio" name="question3">The applet makes the Java code secure and portable<br>
    <input type="radio" name="question3">Use of exception handling<br>
    <input type="radio" name="question3">Dynamic binding between objects<br>
    
    Q4.Which of the following is not a Java features?<br>
    <input type="radio" name="question4">Dynamic<br>
    <input type="radio" name="question4">Architecture Neutral<br>
    <input type="radio" name="question4" id="correct4">Use of pointers<br>
    <input type="radio" name="question4">Object-oriented<br>

    Q5. The \u0021 article referred to as a<br>
    <input type="radio" name="question5" id="correct5">Unicode escape sequence<br>
    <input type="radio" name="question5"> Octal escape<br>
    <input type="radio" name="question5"> Hexadecimal<br>
    <input type="radio" name="question5"> Line feed<br>

    Q6_____ is used to find and fix bugs in the Java programs.<br>    
    <input type="radio" name="question6"> JVM<br>
    <input type="radio" name="question6"> JRE<br>
    <input type="radio" name="question6"> JDK<br>
    <input type="radio" name="question6" id="correct6"> JDB<br>

    Q7.What is the return type of the hashCode() method in the Object class?<br>

    <input type="radio" name="question7"> Object<br>
    <input type="radio" name="question7" id="correct7">int<br>
    <input type="radio" name="question7">long<br>
    <input type="radio" name="question7">void<br>

    Q8.Which of the following is a valid long literal?<br>

    <input type="radio" name="question8">ABH8097<br>
    <input type="radio" name="question8">L990023<br>
    <input type="radio" name="question8">904423<br>
    <input type="radio" name="question8" id="correct8">0xnf029L<br>

    Q9.Which of the following tool is used to generate API documentation in HTML format from doc comments in source code?<br>

    <input type="radio" name="question9">javap tool<br>
    <input type="radio" name="question9">javaw command<br>
    <input type="radio" name="question9" id="correct9">Javadoc tool<br>
    <input type="radio" name="question9" >javah command<br>

    Q10.Which of the following creates a List of 3 visible items and multiple selections abled?<br>

    <input type="radio" name="question10">new List(false, 3)<br>
    <input type="radio" name="question10" id="correct10">new List(3, true)<br>
    <input type="radio" name="question10">new List(true, 3)<br>
    <input type="radio" name="question10">new List(3, false)<br>

    <input type="submit" name="submit" value="submitQuiz" onclick="result()" ><br>

   

    <script type="text/javascript">
        function result(){
           //body..
           var score=0;
           if(document.getElementById('correct2').checked)
           {
               score++;
           }
           if(document.getElementById('correct2').checked)
           {
               score++;
           }
           if(document.getElementById('correct3').checked)
           {
               score++;
           }
           if(document.getElementById('correct4').checked)
           {
               score++;
           }
           if(document.getElementById('correct5').checked)
           {
               score++;
           }
           if(document.getElementById('correct6').checked)
           {
               score++;
           }
           if(document.getElementById('correct7').checked)
           {
               score++;
           }
           if(document.getElementById('correct8').checked)
           {
               score++;
           }
           if(document.getElementById('correct9').checked)
           {
               score++;
           }
           if(document.getElementById('correct10').checked)
           {
               score++;
           }
           document.write("Your Score Is:"+score);
           
          
        }

    </script>

</body>
</html>