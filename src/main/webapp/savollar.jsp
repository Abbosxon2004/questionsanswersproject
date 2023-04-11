<%@ page import="uz.kiuf.questions_answers_project.beans.Question" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<style>


</style>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">

    <title>Services</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

    <link rel="stylesheet" type="text/css" href="css/style.css">

    <link rel="stylesheet" href="css/responsive.css">

    <link rel="icon" href="images/fevicon.png" type="image/gif"/>

    <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">

    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">

    <link href="https://fonts.googleapis.com/css?family=Poppins:400,700|Righteous&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css"
          media="screen">
</head>
<body>
<!-- header section start -->
<div class="header_section">
    <div class="header_main">
        <div class="mobile_menu">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="logo_mobile"><a href="index.jsp"><img src="images/logo.png"></a></div>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="index.jsp">Home</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="/questions">Savollar</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link " href="contact.jsp">Aloqa</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
        <div class="container-fluid">
            <div class="logo"><a href="index.jsp"><img src="images/logo.png"></a></div>
            <div class="menu_main">
                <ul>
                    <li class="active"><a href="index.jsp">Home</a></li>

                    <li><a href="/questions">Savollar</a></li>

                    <li><a href="contact.jsp">Aloqa</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- header section end -->

<!-- savol section start -->
<div class="services_section layout_padding">
    <style>
        #quiz-container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            border-radius: 5px;
        }

        h1 {
            text-align: center;
            margin-top: 0;
        }

        p {
            font-size: 18px;
            line-height: 1.5;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-size: 16px;
        }

        input[type="radio"] {
            margin-right: 10px;
        }

        button {
            display: block;
            margin: 0 auto;
            padding: 10px 20px;
            font-size: 18px;
            background-color: #008CBA;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #006D84;
        }

        /* Quiz-specific styles */
        fieldset {
            margin-bottom: 20px;
            padding: 20px;
            border: 2px solid #ddd;
            border-radius: 5px;
        }

        fieldset legend {
            font-size: 20px;
            font-weight: bold;
            margin-bottom: 10px;
        }

        fieldset p {
            margin-top: 0;
        }

        .correct {
            color: green;
            font-weight: bold;
        }

        .incorrect {
            color: red;
            font-weight: bold;
        }

        .score {
            margin-top: 20px;
            font-size: 24px;
            font-weight: bold;
            text-align: center;
        }

        .score.good {
            color: green;
        }

        .score.bad {
            color: red;
        }

        .hidden {
            display: none;
        }
    </style>

    <%List<Question> questionList = (List<Question>) request.getAttribute("questions");%>


    <div class="container">
        <div id="quiz-container">
            <h1>Quiz Title</h1>
            <p>Quiz description goes here.</p>
            <form action="/questions" method="post">

                <%
                    for (int i = 0; i < questionList.size(); i++) {%>
                <fieldset>
                    <legend>Question <%=i + 1%>
                    </legend>
                    <p><%=questionList.get(i).getQuestion()%>
                    </p>
                    <label><input type="radio" name="q<%= i %>" value="1"
                                  required> <%=questionList.get(i).getOption_1()%>
                    </label>
                    <label><input type="radio" name="q<%= i %>" value="2"
                                  required> <%=questionList.get(i).getOption_2()%>
                    </label>
                    <label><input type="radio" name="q<%= i %>" value="3"
                                  required> <%=questionList.get(i).getOption_3()%>
                    </label>
                </fieldset>
                <%}%>

                <input type="text" class="mail_text" placeholder="Ismingizni kiriting" name="sender" value="" required>
                <br>
                <input type="number" class="mail_text" placeholder="Yoshingizni kiriting" name="age" value="" required>

                <button type="submit">Submit Answers</button>
            </form>
        </div>
    </div>


</div>
<!-- savol section end -->


<!-- footer section start -->
<div class="footer_section layout_padding" style="background-color: rgb(205, 200, 200);">

    <div class="container">
        <div class="location_main">
            <div class="call_text"><img src="images/call-icon.png"></div>
            <div class="call_text"><a href="#">Call +998 33 111 30 35</a></div>
            <div class="call_text"><img src="images/mail-icon.png"></div>
            <div class="call_text"><a href="#">premiumme33@gmail.com</a></div>
        </div>
        <div class="social_icon">
            <ul>
                <li><a href="#"><img src="images/fb-icon.png"></a></li>
                <li><a href="#"><img src="images/twitter-icon.png"></a></li>
                <li><a href="#"><img src="images/linkedin-icon.png"></a></li>
                <li><a href="#"><img src="images/instagram-icon.png"></a></li>
            </ul>
        </div>
    </div>
</div>
<!-- footer section end -->
<!-- copyright section start -->
<div class="copyright_section">
    <div class="container">
        <p class="copyright_text"> Design by Zufarbek and Sarvar in_  Backend by Abbosxon<a href="#"> UC </a> _team</p>
    </div>
</div>
<!-- copyright section end -->
<!-- Javascript files-->
<script src="js/jquery.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/jquery-3.0.0.min.js"></script>
<script src="js/plugin.js"></script>
<!-- sidebar -->
<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="js/custom.js"></script>
<!-- javascript -->
<script src="js/owl.carousel.js"></script>
<script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
</body>
</html>