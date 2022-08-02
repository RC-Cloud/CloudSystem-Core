package com.rccloud.cloud.command.commands.template;

import com.rccloud.cloud.api.utils.APIUtils;

public class TemplateListCommand {

     public static void onTemplate(String[] args) {
          APIUtils.listDirectorys("/home/cloud/templates/");
     }
}
