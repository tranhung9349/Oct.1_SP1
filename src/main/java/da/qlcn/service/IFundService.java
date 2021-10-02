package da.qlcn.service;

import da.qlcn.model.Fund;

import java.util.Optional;

public interface IFundService extends IGeneralService <Fund>{
    Iterable<Fund> findByUserId(long userId);
}
