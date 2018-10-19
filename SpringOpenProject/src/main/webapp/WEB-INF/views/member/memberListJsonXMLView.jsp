<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/default.css">
    <link rel="stylesheet" href="../css/memberList.css">
</head>
<body>
<div style="width: 750px; margin: auto">
<%@include file="/WEB-INF/views/header/menu.jsp" %>
<h2>회원리스트</h2>
<button class="btn" onclick="json()">json</button><button class="btn" onclick="XML()">XML</button>
<p id="jj"></p>
<table>

    <tr class="tablehead">
        <td>
            Id
        </td>
        <td>
            pwd
        </td>
        <td>
            name
        </td>
        <td>
            photo
        </td>
        <td>
            수정 / 삭제
        </td>
    </tr>

    <tbody id="tbody">
    <%-- List의 값 하나씩 출력.--%>
    <script>
        function json(){
            //append할 tbody,p 태그 초기화
            resett();
            $.ajax({
                //ajax로 비동기 식으로 JSON값으로 변환된 memberList 반환
                url:'<%=request.getContextPath()%>/memberListJson',
                success:function (data) {
                    $('#jj').append('JSON 형식 ajax로 받은값');
             //       $('#jsonS').append(data.trim());
                    //공백 제거
                    jasonData = JSON.parse(data.trim());
                    $(jasonData.members).each(function (key, value) {
                        //table생성
                        $('#tbody').append(
                            '<tr> <td>'
                            + value.userId+'</td> <td>'
                            + value.userPwd+'</td> <td>'
                            + value.userName+'</td> <td>' +
                            '<img style="width: 160px" alt="회원사진" src="${pageContext.request.contextPath}/uploadFile/userphoto/'
                            + value.userPhoto+'"></td>'
                            +'<td><a href="../control/remove.jsp?modiid='+value.userId+'"><button>수정</button></a> / ' +
                            '<a href="../control/remove.jsp?removeid='+value.userId+'"><button>삭제</button></a></td> </tr>'
                        )
                    });
                },
                error:function () {
                    alert("error")
                }

            });
        }
        function XML(){
            //append할 tbody,p 태그 초기화
            resett();
            $.ajax({
                //ajax로 비동기 식으로 XML값으로 변환된 memberList 반환
                url:'<%=request.getContextPath()%>/memberListXML',
                datatype:'xml',
                success:function (data) {
          //          $('#jsonS').append($(data).text());
                    $('#jj').append('XML 형식 ajax로 받은값');
                    $(data).find('member').each(function () {
                        //공백제거한 값으로 table 생성
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          var userid = $(this).find('userId').text().trim();
                        var userpwd =$(this).find('userPwd').text().trim();
                        var username = $(this).find('userName').text().trim();
                        var userphoto = $(this).find('userPhoto').text().trim();
                        $('#tbody').append(
                            '<tr> <td>'
                            +userid+'</td> <td>'
                            + userpwd+'</td> <td>'
                            +username+'</td> <td>' +
                            '<img style="width: 160px" alt="회원사진" src="${pageContext.request.contextPath}/uploadFile/userphoto/'
                            + userphoto+'"></td>'
                            +'<td><a href="../control/remove.jsp?modiid='+userid+'"><button>수정</button></a> / ' +
                            '<a href="../control/remove.jsp?removeid='+userid+'"><button>삭제</button></a></td> </tr>'
                        )

                    })
                },
                error:function () {
                    alert("error")
                }

            });
        }

        function resett() {
            $('#jj').text('');
            $('#tbody').text('');
        }
    </script>
    </tbody>
</table>
</div>
</body>
</html>