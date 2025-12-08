package com.orchard.service;

import javax.servlet.http.HttpServletResponse;

public interface ReportService {
    /**
     * 导出记录的excel数据
     * @param response
     */
    void exportBusinessData(HttpServletResponse response);
}
