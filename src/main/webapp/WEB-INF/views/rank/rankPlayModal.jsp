<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal-header">
	<h1 class="modal-title fs-5" id="petReady">Hi,
		${petDTO.pet_name}</h1>
	<button type="button" class="btn-close" data-bs-dismiss="modal"
		aria-label="Close">X</button>
</div>

<div class="modal-body">
	<!-- 펫 상태 리스트 -->
	<div class="tm-block-col tm-col-account-settings" id="petStatusList">
		<div class="tm-bg-primary-dark tm-block tm-block-settings">
			<h2 class="tm-block-title">캐릭터 정보</h2>
			<form action="" class="tm-signup-form row">
				<div class="form-group col-lg-6">
					<label for="pet_spc">종족</label> <input id="pet_spc" name="pet_spc"
						value="${petDTO.pet_spc}" type="text" class="form-control validate"
						readonly style="background-color: #4e657a" />
				</div>
				<div class="form-group col-lg-6">
					<label for="pet_level">레벨</label> <input id="pet_level"
						name="pet_level" value="${petDTO.pet_level}" type="text"
						class="form-control validate" readonly
						style="background-color: #4e657a" />
				</div>
				<div class="form-group col-lg-6">
					<label for="pet_exp">경험치</label> <input id="pet_exp" name="pet_exp"
						value="${petDTO.pet_exp}" type="text" class="form-control validate"
						readonly style="background-color: #4e657a" />
				</div>
				<div class="form-group col-lg-6">
					<label for="pet_hp">체력</label> <input id="pet_hp" name="pet_hp"
						value="${petDTO.pet_hp}" type="text" class="form-control validate"
						readonly style="background-color: #4e657a" />
				</div>
				<div class="form-group col-lg-6">
					<label for="pet_atk">공격력</label> <input id="pet_atk" name="pet_atk"
						value="${petDTO.pet_atk}" type="text" class="form-control validate"
						readonly style="background-color: #4e657a" />
				</div>
				<div class="form-group col-lg-6">
					<label for="pet_dod">회피력</label> <input id="pet_dod" name="pet_dod"
						value="${petDTO.pet_dod}" type="text" class="form-control validate"
						readonly style="background-color: #4e657a" />
				</div>
			</form>
		</div>
	</div>
</div>
<div class="modal-footer">
	<div class="input-group mb-3 justify-content-center">

		<a
			href="../ingame/fight?item_num=${petDTO.item_num}&user_id=${petDTO.user_id}"
			class="btn btn-outline-warning"> 싸우러 가기</a>

	</div>

</div>