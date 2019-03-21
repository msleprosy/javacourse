package com.epam.javacourse.reporting;

import java.io.File;

/**
 * Created by veronika on 21.03.2019.
 */
public interface ReportComponent {
    File generateReport() throws Exception;
}

