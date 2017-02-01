package com.odaniel.practica.Presentation.Base;

import android.content.Context;

import com.odaniel.practica.Models.Response;

/**
 * The interface Base view.
 */
public interface IBaseView {
    /**
     * Gets context.
     *
     * @return the context
     */
    Context getContext();

    /**
     * Update progress.
     *
     * @param progress    the progress
     * @param titleDialog the title dialog
     */
    void updateProgress(int progress, String titleDialog);

    /**
     * On unauthorized user.
     *
     * @param response the response
     */
    void onUnauthorizedUser(Response response);

    /**
     * On failed.
     *
     * @param response the response
     */
    void onFailed(Response response);
}
