		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("EQ_deleteState", 0);// 未删除
		paramMap.put("EQ_bom.id", id);// 同一bom单
		paramMap.put("ORDERASC_addTime", 0);// 选中
		if(pnList!=null&&pnList.size()>0){
			paramMap.put("IN_pn",pnList);
		}
		return super.search(paramMap);