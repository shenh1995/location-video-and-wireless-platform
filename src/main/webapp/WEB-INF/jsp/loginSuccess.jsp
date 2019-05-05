<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ch">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<script type="text/javascript" src="./plugins/jquery-1.7.js"></script>  
<title>管理后台</title>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
	$(function() {
		$(".meun-item").click(function() {
			$(".meun-item").removeClass("meun-item-active");
			$(this).addClass("meun-item-active");
			var itmeObj = $(".meun-item").find("img");
			itmeObj.each(function() {
				var items = $(this).attr("src");
				items = items.replace("_grey.png", ".png");
				items = items.replace(".png", "_grey.png")
				$(this).attr("src", items);
			});
			var attrObj = $(this).find("img").attr("src");
			;
			attrObj = attrObj.replace("_grey.png", ".png");
			$(this).find("img").attr("src", attrObj);
		});
		$("#topAD").click(function() {
			$("#topA").toggleClass(" glyphicon-triangle-right");
			$("#topA").toggleClass(" glyphicon-triangle-bottom");
		});
		$("#topBD").click(function() {
			$("#topB").toggleClass(" glyphicon-triangle-right");
			$("#topB").toggleClass(" glyphicon-triangle-bottom");
		});
		$("#topCD").click(function() {
			$("#topC").toggleClass(" glyphicon-triangle-right");
			$("#topC").toggleClass(" glyphicon-triangle-bottom");
		});
		$(".toggle-btn").click(function() {
			$("#leftMeun").toggleClass("show");
			$("#rightContent").toggleClass("pd0px");
		})

	})
	
	$(document).ready(function() {
		loadBoundInfo();
	});
		    function loadBoundInfo() {
				$.ajax({
				type:"GET",
				url:"/demo/getBoundInfos",
				data:{"username":"1","password":"00"},
				async: false,
				success: function(data) {
					
					var table = $('#mainContent');
				//	alert(table);
				table.empty();
				for(var l=0;l<=data.length;l++){
					var content = 
						'<div class="row">' + 
								'<div class="col-xs-1">' + data[l].id + '</div>'+
								'<div class="col-xs-2">' + data[l].mac_name + '</div>' +
								'<div class="col-xs-1">' + data[l].human_picture_path + '</div>'+
								'<div class=\"col-xs-2">' + 
								'<button class="btn btn-success btn-xs" data-toggle="modal" data-target="#reviseSchool">修改</button>' +
								'<button class="btn btn-danger btn-xs" data-toggle="modal" data-target="#deleteSchool">删除</button>' +
								'</div>' + 
								'</div>';
					table.append(content);	
						}
								}
							});
				}
		    setInterval(loadBoundInfo, 100000);
</script>
<!--[if lt IE 9]>
  <script src="js/html5shiv.min.js"></script>
  <script src="js/respond.min.js"></script>
<![endif]-->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/slide.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/flat-ui.min.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.nouislider.css">
</head>

<body>
	<div id="wrap">
		<!-- 左侧菜单栏目块 -->
		<div class="leftMeun" id="leftMeun">
			<div id="personInfor">
				<p id="userName">沈鸿</p>
				<p>
					<span>shenh@powerlbs.com</span>
				</p>
			</div>
			<div class="meun-item" href="#scho" aria-controls="scho" role="tab"
				data-toggle="tab">
				<img src="images/icon_card_grey.png">绑定信息
			</div>
			<div class="meun-item" href="#chan" aria-controls="chan" role="tab"
				data-toggle="tab">
				<img src="images/icon_rule_grey.png">修改密码
			</div>
		</div>
		<!-- 右侧具体内容栏目 -->
		<div id="rightContent">
			<a class="toggle-btn" id="nimei"> <i
				class="glyphicon glyphicon-align-justify"></i>
			</a>
			<!-- Tab panes -->
			<div class="tab-content">
				<!-- 修改密码模块 -->
				<div role="tabpanel" class="tab-pane" id="chan">
					<div class="check-div">原始密码为12312313</div>
					<div
						style="padding: 50px 0; margin-top: 50px; background-color: #fff; text-align: right; width: 420px; margin: 50px auto;">
						<form class="form-horizontal">
							<div class="form-group">
								<label for="sKnot" class="col-xs-4 control-label">原密码：</label>
								<div class="col-xs-5">
									<input type="" class="form-control input-sm duiqi" id="sKnot"
										placeholder="" style="margin-top: 7px;">
								</div>
							</div>
							<div class="form-group">
								<label for="sKnot" class="col-xs-4 control-label">新密码：</label>
								<div class="col-xs-5">
									<input type="" class="form-control input-sm duiqi" id="sKnot"
										placeholder="" style="margin-top: 7px;">
								</div>
							</div>
							<div class="form-group">
								<label for="sKnot" class="col-xs-4 control-label">重复密码：</label>
								<div class="col-xs-5">
									<input type="" class="form-control input-sm duiqi" id="sKnot"
										placeholder="" style="margin-top: 7px;">
								</div>
							</div>
							<div class="form-group text-right">
								<div class="col-xs-offset-4 col-xs-5"
									style="margin-left: 169px;">
									<button type="reset" class="btn btn-xs btn-white">取 消</button>
									<button type="submit" class="btn btn-xs btn-green">保存</button>
								</div>
							</div>
						</form>
					</div>

				</div>
				<!--地区管理模块-->
				<div role="tabpanel" class="tab-pane active" id="scho">

					<div class="check-div form-inline">
						<div class="col-lg-4 col-xs-5">
							<input type="text" class=" form-control input-sm "
								placeholder="输入文字搜索">
							<button class="btn btn-white btn-xs ">查 询</button>
						</div>
					</div>
					<div class="data-div">
						<div class="row tableHeader">
							<div class="col-xs-1 ">编号</div>
							<div class="col-xs-2 ">MAC地址</div>
							<div class="col-xs-1">照片路径</div>
							<div class="col-xs-2">操作</div>
						</div>
						<div class="tablebody" id="mainContent">
						</div>

					</div>
					<!--页码块-->
					<footer class="footer">
						<ul class="pagination">
							<li><select>
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
									<option>6</option>
									<option>7</option>
									<option>8</option>
									<option>9</option>
									<option>10</option>
							</select> 页</li>
							<li class="gray">共20页</li>
							<li><i class="glyphicon glyphicon-menu-left"> </i></li>
							<li><i class="glyphicon glyphicon-menu-right"> </i></li>
						</ul>
					</footer>

					<!--弹出修改用户窗口-->
					<div class="modal fade" id="reviseSchool" role="dialog"
						aria-labelledby="gridSystemModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="gridSystemModalLabel">修改绑定关系</h4>
								</div>
								<div class="modal-body">
									<div class="container-fluid">
										<form class="form-horizontal">
											<div class="form-group ">
												<label for="sName" class="col-xs-3 control-label">mac地址：</label>
												<div class="col-xs-8 ">
													<input type="email" class="form-control input-sm duiqi"
														id="sName" placeholder="">
												</div>
											</div>
											<div class="form-group ">
												<label for="sName" class="col-xs-3 control-label">照片路径：</label>
												<div class="col-xs-8 ">
													<input type="email" class="form-control input-sm duiqi"
														id="sName" placeholder="">
												</div>
											</div>
										</form>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-xs btn-white"
										data-dismiss="modal">取 消</button>
									<button type="button" class="btn btn-xs btn-green">保 存</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
					<!-- /.modal -->

					<!--弹出删除用户警告窗口-->
					<div class="modal fade" id="deleteSchool" role="dialog"
						aria-labelledby="gridSystemModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="gridSystemModalLabel">提示</h4>
								</div>
								<div class="modal-body">
									<div class="container-fluid">确定要删除该地区？删除后不可恢复！</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-xs btn-white"
										data-dismiss="modal">取 消</button>
									<button type="button" class="btn btn-xs btn-danger">保
										存</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
					<!-- /.modal -->

				</div>
			</div>
		</div>
	</div>
</body>

</html>