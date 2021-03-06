package com.online.bank.digital.controller;

import com.online.bank.digital.model.AccountHolder;
import com.online.bank.digital.repository.IAccountHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccountHolderController {
    private static Logger LOG = LoggerFactory.getLogger(AccountHolderController.class);

    @Autowired
    private IAccountHolder accountHolderDAO;

    @PostMapping(value = "/saveOrUpdateAccountHolder", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AccountHolder saveOrUpdateAccountHolder(@RequestBody AccountHolder accountHolder) throws Exception {
        LOG.info("Saving or updateAccountHolder account holder");
        LOG.info("firstname {}, lastname {}, emailaddress {}",
                accountHolder.getFirstName(),
                accountHolder.getLastName(),
                accountHolder.getEmailAddress());
        return accountHolderDAO.saveOrUpdateAccountHolder(accountHolder);
    }

    @GetMapping(value = "/getAccountHolderByAccountHolderUid", produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountHolder getAccountHolderByAccountHolderUid(@RequestParam final int accountHolderUid) throws Exception {
        LOG.info("Getting details of accountHolderUid {}", accountHolderUid);
        return accountHolderDAO.getAccountHolderByAccountHolderUid(accountHolderUid);
    }

    @PostMapping(value = "/updateAccountHolder", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AccountHolder updateAccountHolder(@RequestBody AccountHolder accountHolder) throws Exception {
        LOG.info("Update for account holder {}", accountHolder.getAccountHolderUid());
        return accountHolderDAO.updateAccountHolder(accountHolder);
    }

    @GetMapping(value = "/deleteAccountHolder")
    public void deleteAccountHolder(@RequestParam int accountHolderId) throws Exception {
        accountHolderDAO.deleteAccountHolder(accountHolderId);
    }
}