package com.sankuai.ee.mcode.apiserver.controller.friday.setting;

import com.sankuai.ee.mcode.apiserver.annotation.RepositoryParam;
import com.sankuai.ee.mcode.apiserver.constants.RestUri;
import com.sankuai.ee.mcode.extension.service.friday.api.RepositoryMCopilotSettingService;
import com.sankuai.ee.mcode.share.domain.friday.setting.RepositoryMCopilotSetting;
import com.sankuai.ee.mcode.share.domain.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestUri.FridayAPI + RestUri.REPO_URI + "/settings")
public class RepositorySettingResource {
    private final RepositoryMCopilotSettingService repositoryMCopilotSettingService;

    @Autowired
    public RepositorySettingResource(RepositoryMCopilotSettingService repositoryMCopilotSettingService) {
        this.repositoryMCopilotSettingService = repositoryMCopilotSettingService;
    }

    @GetMapping
    public RepositoryMCopilotSetting getSetting(@RepositoryParam Repository repository) {
        return repositoryMCopilotSettingService.getRepositoryMCopilotSetting(repository.getId());
    }

    @PutMapping
    public RepositoryMCopilotSetting createOrUpdateSetting(@RepositoryParam Repository repository,
                                                           @RequestBody RepositoryMCopilotSetting setting) {
        return repositoryMCopilotSettingService.createOrUpdateSetting(repository.getId(), setting);
    }
}
