<script th:src="@{https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js}"></script>
					<select class="combox" name="POS_STATUS" id="selected">
						<option value="2">-请选择-</option>
						<option value="0">启用</option>
						<option value="1">停用</option>
					</select>								
					<button class="ch-btn-skin ch-btn-small ch-icon-refresh" type="reset" onclick="reset();">重 置</button></a>
		<script type="text/javascript">	     
			function reset(){			
				$("select[name='POS_STATUS']").find("option[value='2']").attr("selected",true);
			}
		</script>
</script>