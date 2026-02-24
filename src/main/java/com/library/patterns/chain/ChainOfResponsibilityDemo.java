package com.library.patterns.chain;

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

        System.out.println(teamLeader.handle(300_000));
        System.out.println(teamLeader.handle(1_500_000));
        System.out.println(teamLeader.handle(11_000_000));
    }
}
