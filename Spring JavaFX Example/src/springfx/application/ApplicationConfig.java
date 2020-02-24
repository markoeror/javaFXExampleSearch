package springfx.application;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javafx.application.HostServices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import springfx.controls.ControlsController;
import springfx.data.DataAccessor;
import springfx.data.MockDataAccessor;
import springfx.editor.EditorController;
import springfx.editor.EditorControllerImpl;
import springfx.model.Model;
import springfx.model.ModelImpl;
import springfx.search.SearchController;
import springfx.table.TableController;

@Configuration
public class ApplicationConfig {
    
    @Bean
    public DataAccessor dataAccessor() {
        return new MockDataAccessor();
    }
    
    @Bean
    public Executor executor() {
        return Executors.newCachedThreadPool(r -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t ;
        });
    }
    
    @Bean
    public Model model() {
        return new ModelImpl();
    }
    
    @Bean
    @Scope("prototype")
    public EditorController editorPresenter(Model model) {
        return new EditorControllerImpl(model);
    }
    
    @Bean
    @Scope("prototype")
    public TableController tablePresenter(Model model) {
        return new TableController(model);
    }
    
    @Bean
    @Scope("prototype")
    public ControlsController controlsPresenter(Model model, HostServices hostServices) {
        return new ControlsController(model, hostServices);
    }
    
    @Bean
    @Scope("prototype")
    public SearchController searchPresenter(Model model) {
        return new SearchController(model);
    }
}
