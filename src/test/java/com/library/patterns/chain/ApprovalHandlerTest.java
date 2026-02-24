package com.library.patterns.chain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ApprovalHandlerTest {

    @Test
    void should_returnManagerApproval_when_amountFitsManagerLimit() {
        ApprovalHandler teamLeader = new TeamLeaderApprovalHandler();
        ApprovalHandler manager = new ManagerApprovalHandler();
        ApprovalHandler director = new DirectorApprovalHandler();
        teamLeader.linkWith(manager).linkWith(director);

        ApprovalDecision result = teamLeader.handle(new ApprovalRequest("A-1", "STAFF", "OPS", 1_000_000, "trace-1"));

        assertTrue(result.approved());
        assertEquals("MANAGER", result.approver());
    }

    @Test
    void should_reject_when_amountExceedsAllLimits() {
        ApprovalHandler teamLeader = new TeamLeaderApprovalHandler();
        ApprovalHandler manager = new ManagerApprovalHandler();
        ApprovalHandler director = new DirectorApprovalHandler();
        teamLeader.linkWith(manager).linkWith(director);

        ApprovalDecision result = teamLeader.handle(new ApprovalRequest("A-2", "STAFF", "OPS", 12_000_000, "trace-2"));

        assertFalse(result.approved());
        assertEquals("LIMIT_EXCEEDED", result.errorCode());
    }
}
