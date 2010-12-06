<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
</head>
<body>

<br>
<br>
<br>
		<div id="content">
			<div class="grid4col">
				<div class="column" >
					<!-- with itunes -->
					<a class="block" href="/itunes/digital-music-basics/">

						<h3 style="color:#666666">순천만 미나리</h3>
						<p>미나리는 비타민이 풍부한 알갈리성 식품이며, 땀띠가 심할 때 즙을 바르면 낫는다.
						소변을 잘 나오게 하고 부은 것을 내리게 한다.
						간보호, 담즙 분비작용, 항지방간작용, 간경변을 막는 작용을 한다. 
						미나리에는칼슘, 칼륨, 철, 베타 - 카로틴, 엽산, 비타민C, 식물성 섬유등 좋은 성분들을 포함하고 있습니다. 
						 <span class="more">더 보기&raquo;</span></p>
						<img src="<%= request.getContextPath() %>/images/catalog/dropwort.jpg" width="200" height="200" alt="순천만 미나리" />
					</a>
				</div>
				<div class="column">
					<a class="block" href="/itunes/whats-new/">
						<h3>순천만 매실</h3>
						<p> 매실에는 살균과 피로회복에 뛰어나고 칼슘흡수를 촉진하는 구연산과 사과산이 풍부하다. 
								 소화 불량, 위장 장애를 없애고, 
								 체질이 산성으로 기우는 것을 막아 약 알칼리성으로 유지할 수 있다. 
								 간장을 보호하고 간 기능을 향상시키며 만성 변비를 없앤다. 
								 매실 속에 들어있는 칼슘의 양은 포도의 2배, 멜론의 4배에 이른다.
 								<span class="more">더보기&raquo;</span></p>
						<img src="<%= request.getContextPath()%>/images/catalog/maesil.jpg" width="200" height="148" alt="순천만 매실" />
					</a>
				</div>
				<div class="column">
						<h3>카테고리 </h3>
						<p><a href='<s:url namespace="/shop" action="category_list"/>'>상품 카테고리</a></p>
						<p><a title="로그인이 필요합니다." href='<s:url namespace="/shop" action="order_list"/>'>주문예약조회</a></p>
				</div>
				<div class="column">
					<h3>순천만 풍경</h3>
					<img src="<%= request.getContextPath() %>/images/bay/suncheon-bay.png" width="210" height="140" alt="순천만  S자 수로" />
          <img src="<%= request.getContextPath() %>/images/bay/suncheon-bay2.png" width="210" height="140" alt="순천만  S자 수로" />
         <img src="<%= request.getContextPath() %>/images/bay/suncheon-bay4.png" width="210" height="140" alt="순천만  S자 수로" />
				</div>
			</div><!--/grid4col-->
		</div><!--/content-->
</body>
</html>