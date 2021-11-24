<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'/>
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/static/uni.ico" type="image/x-icon">
    <title><%=request.getParameter("title")%>
    </title>
    <style>
        body {
            background: linear-gradient(45deg, #01516e 40%, #57aec7 60%);
        }

        .container {
            padding-right: 0 !important;
            padding-left: 0 !important;
        }

        .titlecolor {
            background: linear-gradient(45deg, #022e3f 40%, rgba(2, 61, 80, 0.97) 60%);
        }

        .navbar {
            padding-left: 10px !important;
            padding-right: 10px !important;
            background: linear-gradient(45deg, #01516e 40%, #57aec7 60%);
        }

        .table-transparent {
            background-color: #343a4000 !important
        }

        .tabla {
            background-color: #7097af;
            padding-left: 30px;
            padding-right: 30px;
        }

        thead {
            border-top: hidden;
            font-size: 14px;
        }

        .table td {
            padding: 0.5rem;
            font-weight: 500;
        }

        .table th {
            padding: 0.5rem;
            font-weight: 100;
        }

        .fila-red {
            background-color: #ba49498c;
        }

        .fila-blue {
            background-color: #2441ac8c;
        }

        .fila-purple {
            background-color: #a4219a8c;
        }

        .fila-yellow {
            background-color: #f0e01f91;
        }

        .fila-green{
            background-color: darkgreen;
        }


    </style>

</head>
