package com.odaniel.practica.Presentation.Base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.odaniel.practica.Models.Response;
import com.odaniel.practica.R;
import com.odaniel.practica.Utils.Constants;


/**
 * The type Base activity.
 */
public class BaseActivity extends AppCompatActivity implements IBaseView
{

    /**
     * Properties.
     */
    // Aqui se deben crear todos los elementos emergentes recurrentes (alertas, progress...)
    private ProgressDialog progressDialog;
    private AlertDialog currentDialog;
    private ActionBar actionBar;
    private DrawerLayout fullView;
    private Toolbar toolbar;


    /**
     * Lyfecycle
     */

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState)
    {
        super.onCreate(savedInstanceState, persistentState);
        progressDialog = new ProgressDialog(BaseActivity.this);
    }

    /**
     * Use toolbar boolean.
     *
     * @return the boolean
     */
    protected boolean useToolbar()
    {
        return true;
    }

    /**
     * Setting toolbar activity
     *
     * @param typeToolbar type toolbar
     */
    public void settingToolbar(int typeToolbar)
    {
        switch (typeToolbar)
        {
            case Constants.ToolBarType.SIMPLE_TOOLBAR:
                actionBar.setDisplayHomeAsUpEnabled(false);
                fullView.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                break;
            case Constants.ToolBarType.BACK_TOOLBAR:
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowHomeEnabled(true);
                actionBar.setDefaultDisplayHomeAsUpEnabled(true);
                break;
            case Constants.ToolBarType.NO_TOOLBAR:
                toolbar.setVisibility(View.GONE);
                break;
            case Constants.ToolBarType.NAVIGATION_DRAWER:
                ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, fullView, toolbar, R.string.app_name, R.string.app_name)
                {

                    public void onDrawerClosed(View drawerView)
                    {
                        super.onDrawerClosed(drawerView);
                    }


                    public void onDrawerOpened(View drawerView)
                    {
                        super.onDrawerOpened(drawerView);
                    }
                };
                fullView.addDrawerListener(drawerToggle);
                drawerToggle.syncState();

                break;
            default:
                break;
        }

    }

    @Override
    public void setContentView(int layoutResID)
    {
        fullView = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        FrameLayout activityContainer = (FrameLayout) fullView.findViewById(R.id.activity_content);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);
        super.setContentView(fullView);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (useToolbar())
        {
            //setSupportActionBar(toolbar);
            actionBar = getSupportActionBar();
            //actionBar.setLogo(R.drawable.image_logo_s);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayUseLogoEnabled(true);
            actionBar.setBackgroundDrawable(ContextCompat.getDrawable(this, R.color.colorPrimary));
        } else
        {
            toolbar.setVisibility(View.GONE);
        }
    }


    /**
     * Actions
     */
    @Override
    public Context getContext()
    {
        return getApplicationContext();
    }

    /**
     * Close popups.
     */
    protected void closePopups()
    {
        // Aquí se deben cerrar todos los elementos emergentes abiertos
        if (currentDialog != null)
        {
            currentDialog.dismiss();
        }
        if (progressDialog != null && progressDialog.isShowing())
        {
            progressDialog.dismiss();
        }
    }

    /**
     * Show dialog.
     *
     * @param type           the type
     * @param title          the title
     * @param message        the message
     * @param negativeButton the negative button
     * @param positiveButton the positive button
     * @param tag            the tag
     */

    protected void showDialog(int type,
                              String title,
                              String message,
                              String negativeButton,
                              String positiveButton,
                              final String tag
    )
    {
        showDialog(type,
                title,
                message,
                negativeButton,
                positiveButton,
                tag,
                null);
    }


    protected void showDialog(int type,
                              String title,
                              String message,
                              String negativeButton,
                              String positiveButton,
                              final String tag,
                              final String responseJson)
    {
        this.closePopups();
        // Aquí se debe implementar la creación de la alerta y mostrarla. Se puede cambiar por
        // cualquier tipo de alerta, se usa AlertDialog.Builder por defecto.
        // El parámetro type puede ser utilizado si se quieren mostrar varios tipos de Alertas con este
        // mismo método.
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        currentDialog = alertBuilder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveButton, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        BaseActivity.this.onDialogOkClick(tag, responseJson);
                    }
                })
                .setNegativeButton(negativeButton, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        BaseActivity.this.onDialogCancelClick(tag);
                    }
                }).create();
        currentDialog.show();
    }
    /**
     * Listeners
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * On dialog ok click.
     *
     * @param dialogTag the dialog tag
     */
    protected void onDialogOkClick(String dialogTag, String responseJson)
    {
        // Aqui se recibe el evento de click en el botón positivo de la alerta
        currentDialog.dismiss();
    }

    protected void onDialogOkClick(String dialogTag)
    {
        // Aqui se recibe el evento de click en el botón positivo de la alerta
        currentDialog.dismiss();
    }


    /**
     * On dialog cancel click.
     *
     * @param dialogTag the dialog tag
     */
    public void onDialogCancelClick(String dialogTag)
    {
        // Aqui se recibe el evento de click en el botón negativo de la alerta
        currentDialog.dismiss();
    }

    @SuppressWarnings("EmptyMethod")
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }

    @Override
    public void updateProgress(int progress, String titleDialog)
    {
        // Se debe implementar el avance del progress
        progressDialog.setTitle(titleDialog);
        progressDialog.incrementProgressBy(progress);
    }

    @Override
    public void onUnauthorizedUser(Response response)
    {
        showDialog(Constants.DialogType.ERROR, getContext().getString(R.string.error_title),
                response.getMessage(), null, Constants.Dialog.OK_BUTTON, Constants.DialogTags.UNAUTHORIZED_RESPONSE);
    }

    @Override
    public void onFailed(Response response)
    {
        showDialog(Constants.DialogType.ERROR, getContext().getString(R.string.error_title),
                response.getMessage(), null, Constants.Dialog.OK_BUTTON, Constants.DialogTags.FAIL_RESPONSE);
    }
}

