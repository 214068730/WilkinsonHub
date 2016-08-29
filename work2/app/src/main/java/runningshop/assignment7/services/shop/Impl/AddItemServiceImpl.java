package runningshop.assignment7.services.shop.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import runningshop.assignment7.conf.util.App;
import runningshop.assignment7.domain.employee.Employee;
import runningshop.assignment7.domain.shop.Item;
import runningshop.assignment7.repository.shop.Impl.ItemRepositoryImpl;
import runningshop.assignment7.repository.shop.ItemRepository;
import runningshop.assignment7.services.shop.AddItemService;

/**
 * Created by Siraaj on 05/08/2016.
 */
public class AddItemServiceImpl extends IntentService implements AddItemService {

    private final ItemRepository repository;
    private static AddItemServiceImpl service = null;

    private static final String ACTION_ADD ="package runningshop.assignment7.services.customer.Impl.action.ADD";
    private static final String EXTRA_ADD = "package runningshop.assignment7.services.customer.Impl.extra.ADD";

    public AddItemServiceImpl() {
        super("AddItemServiceImpl");
        repository = new ItemRepositoryImpl(App.getAppContext());
    }

    public static AddItemServiceImpl getInstance(){
        if(service == null)
            service = new AddItemServiceImpl();
        return service;
    }

    @Override
    public void addItem(Context context, Item item) {
        Intent intent = new Intent(context,AddItemServiceImpl.class);
        intent.putExtra(EXTRA_ADD,item);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            Item itemResources = (Item) intent.getSerializableExtra(EXTRA_ADD);
            Item item = new Item.ItemBuilder()
                    .itemCode(itemResources.getItemCode())
                    .itemName(itemResources.getItemName())
                    .build();
            repository.save(item);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
