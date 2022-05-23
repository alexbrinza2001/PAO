package com.project.pao.services;

import com.project.pao.csvIO.Audit;

public class AuditService {

    public static AuditService service;

    private AuditService() {}

    public static AuditService getService() {
        if (service == null)
            service = new AuditService();
        return service;
    }

    public void auditWrite(String message) {
        Audit audit = Audit.getAudit();

        audit.writeAction(message);
    }
}
