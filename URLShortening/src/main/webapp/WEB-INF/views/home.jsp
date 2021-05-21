<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="UTF-8">
<title>Home</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<style type="text/css">
		.div1{
			width:100%;
    		height:100%;
    		position:relative;
		}
		.div2{
    		position:absolute;
    		left:50%;
    		transform:translate(-50%,0%);
		}
	</style>
</head>
<body>
	<div class="div1">
		<div class="div2">
			<h2>URL Shortening</h2>
			URL 입력 : <input id="input" text="" /> 
			<input type="button" onclick="convert();" value="변경" />
		<div id="result" style="max-width: 1024px;"></div>
		</div>
	</div>
</body>
</html>

<script type="text/javascript">
	function convert() {
		var text = $("#input").val();
		if (text != null) {

			$
					.ajax({
						type : "get",
						url : "/shortening",
						data : {
							url : text
						},
						success : function(data) {
							console.log(data)
							if (data.success) {
								if (data.originUrl) {
									$("#result").html(
											"<p>원본 URL : "
													+ data.urlInfo.originUrl
													+ "</p><p>변경 URL : "
													+ data.urlInfo.shortUrl
													+ "</p><p> 요청 횟수:"
													+ data.urlInfo.callCnt
													+ "</p>");
								} else {
									window
											.open(data.urlInfo.originUrl, "새창",
													"width=1200, height=1000, toolbar=no, top=0, resizable=yes");
								}

							} else {
								$("#result").html(
										"<p>" + text + ' URL Shortening 실패 </p>');
							}

						}
					});

		}
	}
</script>