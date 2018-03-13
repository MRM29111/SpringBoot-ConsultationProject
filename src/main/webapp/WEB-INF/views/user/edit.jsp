<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<h3>Register</h3>
					<form:form method="POST" action="/user/edit/${editModel.id}" modelAttribute="editModel" enctype="multipart/form-data">
						<div class="form-group">
							<form:errors path="*" cssClass="error"/>
						</div>
						<label class="control-label">FirstName</label>
							<form:input path="firstName" cssClass="form-control" title="First Name" />
							
							
						<label class="control-label">LasttName</label>
							<form:input path="lastName" cssClass="form-control" title="Last Name" />
						
						
						<div class="form-group">
  							<label class="control-label">E-mail address</label>
							<form:input path="email" cssClass="form-control" title="E-mail address" disabled="true"/>
											
					
							<label class="control-label">Phone Number</label>
							<form:input path="phoneNumber" cssClass="form-control" title="Phone Number"/>
							
							
							<label class="control-label">Age</label>
							<form:input path="age" cssClass="form-control" title="Age"/>
							
							
							<label class="control-label">Profile Image</label>
							<form:input path="file" type="file" cssClass="form-control" title="Profile Image"/>
							
					
						</div>
						<div class="form-group">
							<span class="input-group-btn">
								<input type="submit" class="btn btn-primary" value="Register">
							</span>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>