package stmall.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import stmall.domain.*;

@Component
public class OrdeMgmtHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<OrdeMgmt>> {

    @Override
    public EntityModel<OrdeMgmt> process(EntityModel<OrdeMgmt> model) {
        return model;
    }
}
