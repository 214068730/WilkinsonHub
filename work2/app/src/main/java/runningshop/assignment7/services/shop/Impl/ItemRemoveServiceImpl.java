package runningshop.assignment7.services.shop.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import runningshop.assignment7.conf.util.App;
import runningshop.assignment7.domain.shop.Item;
import runningshop.assignment7.repository.shop.Impl.ItemRepositoryImpl;
import runningshop.assignment7.repository.shop.ItemRepository;
import runningshop.assignment7.services.shop.ItemRemoveService;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class ItemRemoveServiceImpl extends IntentService implements ItemRemoveService {

    private final ItemRepository repository;
    private static ItemRemoveServiceImpl service = null;

    private static final String ACTION_ADD ="package runningshop.assignment7.services.customer.Impl.action.ADD";
    private static final String EXTRA_ADD = "package runningshop.assignment7.services.customer.Impl.extra.ADD";
    public ItemRemoveServiceImpl() {
        super("ItemRemoveServiceImpl");
        repository = new ItemRepositoryImpl(App.getAppContext());
    }

    public static ItemRemoveServiceImpl getInstance(){
        if(service == null)
            service = new ItemRemoveServiceImpl();
        return service;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Item itemResources = (Item) intent.getSerializableExtra(EXTRA_ADD);
        repository.delete(itemResources);
    }

    @Override
    public void deleteItem(Context context, Item item) {
        Intent intent = new Intent(context,AddItemServiceImpl.class);
        intent.putExtra(EXTRA_ADD,item);
        context.startService(intent);
    }
}
