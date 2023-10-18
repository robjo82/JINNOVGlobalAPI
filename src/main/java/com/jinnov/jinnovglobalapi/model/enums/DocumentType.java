package com.jinnov.jinnovglobalapi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.MessageSource;

import java.util.Locale;

@AllArgsConstructor
@Getter
public enum DocumentType {
    FRAMEWORK_AGREEMENT("frameworkAgreement"),
    STUDY_AGREEMENT("studyAgreement"),
    PURCHASE_ORDER("purchaseOrder"),
    SALES_PROPOSAL("salesProposal"),
    ADVANCE_INVOICE("advanceInvoice"),
    INTERIM_INVOICE("interimInvoice"),
    FINAL_INVOICE("finalInvoice"),
    PAYMENT_SLIP("paymentSlip"),
    CONTRACTOR_SATISFACTION_SURVEY("contractorSatisfactionSurvey"),
    CUSTOMER_SATISFACTION_SURVEY("customerSatisfactionSurvey"),
    INTERIM_ACCEPTANCE_REPORT("interimAcceptanceReport"),
    FINAL_ACCEPTANCE_REPORT("finalAcceptanceReport"),
    MISSION_SUMMARY("missionSummary"),
    MISSION_SUMMARY_TIME_AMENDMENT("missionSummaryTimeAmendment"),
    MISSION_SUMMARY_SCOPE_AMENDMENT("missionSummaryScopeAmendment"),
    MISSION_SUMMARY_COMPENSATION_AMENDMENT("missionSummaryCompensationAmendment"),
    MISSION_SUMMARY_METHODOLOGY_AMENDMENT("missionSummaryMethodologyAmendment"),
    FRAMEWORK_AGREEMENT_METHODOLOGY_AMENDMENT("frameworkAgreementMethodologyAmendment"),
    FRAMEWORK_AGREEMENT_GENERAL_TERMS_AMENDMENT("frameworkAgreementGeneralTermsAmendment"),
    AMENDED_PURCHASE_ORDER("amendedPurchaseOrder"),
    STUDY_AGREEMENT_METHODOLOGY_AMENDMENT("studyAgreementMethodologyAmendment"),
    STUDY_AGREEMENT_TIME_AMENDMENT("studyAgreementTimeAmendment"),
    STUDY_AGREEMENT_PRICING_AMENDMENT("studyAgreementPricingAmendment"),
    STUDY_AGREEMENT_SCOPE_AMENDMENT("studyAgreementScopeAmendment");

    private final String documentType;

    public String getLocalizedValue(Locale locale, MessageSource messageSource){
        return messageSource.getMessage(this.documentType, null, locale);
    }
}
