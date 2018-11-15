
package com.goat.dto;

import java.io.Serializable;
import java.util.List;

public class PageResponse<T> implements Serializable {

    /**
     * @Fields serialVersionUID : 
     */
    private static final long serialVersionUID = -3720728948596761669L;
    /**
     * @Fields data : 数据体
     */
    private List<T> aaData;
    /**
     * 记录请求次数
     */
    private int sEcho;
    /**
     * 同recordsTotal
     */
    private Long iTotalRecords;
    /**
     * 一共多少行.
     */
    private Long iTotalDisplayRecords;
    
    private String exportUrl;

    /**
     * 
     * @Title：PageResponse
     * @Description: 初始化返回列表内容 
     * @author peng.zhang 
     * @date 2016年1月4日 下午1:35:18
     * @param aaData 显示的列表内容
     * @param iTotalRecords 总记录数
     */
    public PageResponse(List<T> aaData, Long iTotalRecords){
    	this.aaData = aaData;
    	this.iTotalDisplayRecords = iTotalRecords;
    	this.iTotalRecords = iTotalRecords;
    }
    public PageResponse(int draw, Long recordsFiltered, Long recordsTotal){
        super();
        this.sEcho = draw;
        this.iTotalRecords = recordsFiltered;
        this.iTotalDisplayRecords = recordsTotal;
    }

    public PageResponse(Long recordsFiltered, Long recordsTotal){
        super();
        this.iTotalRecords = recordsFiltered;
        this.iTotalDisplayRecords = recordsTotal;
    }

    public PageResponse(List<T> data, int sEcho, Long recordsFiltered, Long recordsTotal){
        super();
        this.aaData = data;
        this.sEcho = sEcho;
        this.iTotalRecords = recordsFiltered;
        this.iTotalDisplayRecords = recordsTotal;
    }

    public PageResponse(List<T> data, Long recordsTotal, int sEcho){
        super();
        this.aaData = data;
        this.sEcho = sEcho;
        this.iTotalRecords = recordsTotal;
        this.iTotalDisplayRecords = recordsTotal;
    }

	public List<T> getAaData(){
        return aaData;
    }

    public void setAaData(List<T> data){
        this.aaData = data;
    }

    public int getsEcho(){
        return sEcho;
    }

    public void setsEcho(int draw){
        this.sEcho = draw;
    }

    public Long getiTotalRecords(){
        return iTotalRecords;
    }

    public void setiTotalRecords(Long recordsFiltered){
        this.iTotalRecords = recordsFiltered;
    }

    public Long getiTotalDisplayRecords(){
        return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(Long recordsTotal){
        this.iTotalDisplayRecords = recordsTotal;
    }

	public String getExportUrl() {
		return exportUrl;
	}

	public void setExportUrl(String exportUrl) {
		this.exportUrl = exportUrl;
	}

}
