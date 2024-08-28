package com.senai.sd.shared.utils;

import com.senai.sd.shared.models.InventoryData;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class SystemInfoUtil {

    public static InventoryData collectSystemInfo() {
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();

        InventoryData data = new InventoryData();
        data.setOsName(osBean.getName());
        data.setOsVersion(osBean.getVersion());
        data.setAvailableProcessors(osBean.getAvailableProcessors());
        data.setSystemLoadAverage(osBean.getSystemLoadAverage());

        // Adicione mais informações do sistema conforme necessário
        return data;
    }
}
