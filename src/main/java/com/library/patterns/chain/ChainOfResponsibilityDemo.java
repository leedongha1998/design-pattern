package com.library.patterns.chain;

import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * Chain of Responsibility 패턴 데모입니다.
 */
@Component
public class ChainOfResponsibilityDemo {

    public void run() {
        ApprovalHandler teamLeader = new TeamLeaderApprovalHandler();
        ApprovalHandler manager = new ManagerApprovalHandler();
        ApprovalHandler director = new DirectorApprovalHandler();

        teamLeader.linkWith(manager).linkWith(director);

        System.out.println(teamLeader.handle(new ApprovalRequest("APR-1", "STAFF", "OPS", 300_000, UUID.randomUUID().toString())));
        System.out.println(teamLeader.handle(new ApprovalRequest("APR-2", "STAFF", "OPS", 1_500_000, UUID.randomUUID().toString())));
        System.out.println(teamLeader.handle(new ApprovalRequest("APR-3", "STAFF", "OPS", 11_000_000, UUID.randomUUID().toString())));
    }
}
