<script th:src="@{https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js}"></script>
					<select class="combox" name="POS_STATUS" id="selected">
						<option value="2">-��ѡ��-</option>
						<option value="0">����</option>
						<option value="1">ͣ��</option>
					</select>								
					<button class="ch-btn-skin ch-btn-small ch-icon-refresh" type="reset" onclick="reset();">�� ��</button></a>
		<script type="text/javascript">	     
			function reset(){			
				$("select[name='POS_STATUS']").find("option[value='2']").attr("selected",true);
			}
		</script>
</script>