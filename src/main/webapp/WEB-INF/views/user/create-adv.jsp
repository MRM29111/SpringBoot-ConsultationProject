<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="row">




	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<h3>Create Advertisement</h3>
					<form:form method="POST" action="/user/${advModel.entity.id}/create" modelAttribute="advModel"
					enctype="multipart/form-data">
					
					
						<div class="form-group">
							<form:errors path="*" cssClass="error"/>
						</div>
						<label class="control-label">Car make</label>
							<form:input path="make" cssClass="form-control"  />
							
							
						<label class="control-label">Car model</label>
							<form:input path="model" cssClass="form-control"  />
						
						
						<div class="form-group">
  							<label class="control-label">Car model year</label>
							<form:input path="modelYear" cssClass="form-control" />
							
							
							<label class="control-label">Car price</label>
							<form:input path="price" cssClass="form-control" />
							
							
						<label class="control-label">Car image</label>
							<form:input path="carImage" cssClass="form-control" />
						
						
						<form:hidden path="entity"/>
						
						<label class="control-label">Car EngineCapacity</label>
						<form:input path="engineCapacity" cssClass="form-control"/>
						
						
						<label class="control-label">Choose your color</label>
						<form:select path="color" cssClass="form-control">
							<c:forEach items="${colors}" var="color">
							<form:option value="${color}">${color}</form:option>
							
							</c:forEach>
						</form:select>
						
						<label class="control-label">Choose type of fuel</label>
						<form:select path="fuelType" cssClass="form-control">
							<c:forEach items="${fuelTypes}" var="fuel">
							<form:option value="${fuel}">${fuel.type}</form:option>
							
							</c:forEach>
						</form:select>
						
						<label class="control-label">Choose type of fuel</label>
						<form:select path="bodyType" cssClass="form-control">
							<c:forEach items="${bodyTypes}" var="body">
							<form:option value="${body}">${body}</form:option>
							
							</c:forEach>
						</form:select>
						
						
						<%-- 	<label class="control-label">Who are you?</label>
							<form:select path="role" cssClass="form-control">
								<c:forEach items="${userRole}" var="role">
									<c:if test="${role ne 'ROLE_ADMIN'}">
										<form:option value="${role}">${role.role}</form:option>
									</c:if>
								</c:forEach>
							</form:select> --%>
						</div>
						<div class="form-group">
							<span class="input-group-btn">
								<input type="submit" class="btn btn-primary" value="create advertisement">
							</span>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>