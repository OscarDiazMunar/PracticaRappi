package com.odaniel.practica.Utils;



/**
 * The type Constants.
 */
public class Constants
{

    /**
     * The interface Chars.
     */
    public interface Chars
    {
        /**
         * The constant NULL.
         */
        String NULL = "null";
        /**
         * The constant CHARSET.
         */
        String CHARSET = "≠";
    }

    /**
     * The interface Date
     */
    public interface Date
    {
        /**
         * The constant DATE_FORMAT.
         */
        String DATE_FORMAT = "dd/MM/yyyy";
        /**
         * The constant YEAR_KEY.
         */
        String YEAR_KEY = "years";
        /**
         * The constant MONTH_KEY.
         */
        String MONTH_KEY = "months";
        /**
         * The constant DAY_kEY.
         */
        String DAY_KEY = "days";
        /**
         * The constant CRITERION_LEAP_YEAR1
         */
        int CRITERION_LEAP_YEAR1 = 4;
        /**
         * The constant CRITERION_LEAP_YEAR2
         */
        int CRITERION_LEAP_YEAR2 = 100;
    }

    /**
     * The interface Connection.
     */
    public interface Connection
    {
        /**
         * The constant UNKNOWN_CODE.
         */
        int UNKNOWN_CODE = 800;
        /**
         * The constant TIMEOUT.
         */
        int TIMEOUT = 10000;
        /**
         * The constant LOGIN_URL.
         */
        String LOGIN_URL = "?user=1";

        /**
         * The constant NO_CONNECTION.
         */
        String NO_CONNECTION = "No hubo respuesta del servicio";

        /**
         * The constant NO_INTERNET_NETWORK.
         */
        String NO_INTERNET_NETWORK = "No hay conexion a internet o datos";

        /**
         * The constant RESPONSE_JSON.
         */
        String RESPONSE_JSON = "responsejoson";

        /**
         * The constan MAX_BYTES
         */
        int MAX_BYTES = 10485760;
    }

    /**
     * The interface Http methods type.
     */
    public interface HttpMethodsType
    {
        /**
         * The constant POST.
         */
        String POST = "POST";
        /**
         * The constant GET.
         */
        String GET = "GET";
        /**
         * The constant PUT.
         */
        String PUT = "PUT";
        /**
         * The constant DELETE.
         */
        String DELETE = "DELETE";
    }

    /**
     * The interface Reg exps.
     */
    public interface RegExps
    {
        /**
         * The constant LENGHT_1_OR_MORE.
         */
        String LENGHT_1_OR_MORE = ".{1,}";
        /**
         * The constant LENGHT_3_OR_MORE.
         */
        String LENGHT_3_OR_MORE = ".{3,}";
        /**
         * The constant LENGHT_5_OR_MORE.
         */
        String LENGHT_5_OR_MORE = ".{5,}";
        /**
         * The constant LENGHT_7_OR_MORE.
         */
        String LENGHT_7_OR_MORE = ".{7,}";
        /**
         * The constant LENGHT_10_OR_MORE.
         */
        String LENGHT_10_OR_MORE = ".{10,}";
        /**
         * The constant PATTERN_EMAIL.
         */
        String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        /**
         * The constant PATTERN_PASSWORD.
         */
        String PATTERN_PASSWORD = "^(?=.*[A-Z])(?=.*[+-\\/*.,:;-_!\"@$&\\\\()=?¿])(?=.*[0-9]).{8,}$";
        /**
         * The constant PATTERN_DOCUMENT_ALPHANUMERIC.
         */
        String PATTERN_DOCUMENT_ALPHANUMERIC = "^[0-9a-zA-Z]+$";
        /**
         * The constant PATTERN_TEXT.
         */
        String PATTERN_TEXT = "^[a-zA-Z]+$";

        /**
         * The constant PATTERN_DOCUMENT_NUMERIC.
         */
        String PATTERN_DOCUMENT_NUMERIC = "^[0-9]+$";

    }

    /**
     * The interface Dialog.
     */
    public interface Dialog
    {
        /**
         * The constant OK_BUTTON.
         */
        String OK_BUTTON = "ACEPTAR";

        /**
         * The constant YES_BUTTON.
         */
        String YES_BUTTON = "SI";
        /**
         * The constant NO_BUTTON.
         */
        String NO_BUTTON = "NO";
    }

    /**
     * The interface Dialog type.
     */
    public interface DialogType
    {
        /**
         * The constant INFO.
         */
        int INFO = 0;
        /**
         * The constant OK.
         */
        int OK = 1;
        /**
         * The constant WARNING.
         */
        int WARNING = 2;
        /**
         * The constant ERROR.
         */
        int ERROR = 3;
        /**
         * The constant TEXT_AREA.
         */
        int TEXT_AREA = 4;
    }

    /**
     * The interface Dialog tags.
     */
    public interface DialogTags
    {
        /**
         * The constant OK.
         */
        String OK = "ok";
        /**
         * The constant FAIL_RESPONSE.
         */
        String FAIL_RESPONSE = "fail_response";
        /**
         * The constant UNAUTHORIZED_RESPONSE.
         */
        String UNAUTHORIZED_RESPONSE = "unauthorized_response";
    }

    /**
     * The interface Error text.
     */
    public interface ErrorText
    {
        /**
         * The constant SELECTED_EMPTY.
         */
        String SELECTED_EMPTY = "Seleccione uno...";
        /**
         * The constant FIVE_CARACTER.
         */
        String FIVE_CARACTER = "5 caracter";
        /**
         * The constant ONE_CARACTER.
         */
        String ONE_CARACTER = "1 caracter";
        /**
         * The constant EMPTY.
         */
        String EMPTY = "campo vacio ";
        /**
         * The constant ONLY_TEXT.
         */
        String ONLY_TEXT = "solo texto";
        /**
         * The constant ONLY_NUMERIC.
         */
        String ONLY_NUMERIC = "solo numero";
        /**
         * The constant NAME.
         */
        String NAME = "nombre";
        /**
         * The constant LAST_NAME.
         */
        String LAST_NAME = "apellido";
        /**
         * The constant TELEPHONE.
         */
        String TELEPHONE = "telefono";
        /**
         * The constant DOCUMENT_TYPE.
         */
        String DOCUMENT_TYPE = "tipo documento";
        /**
         * The constant DOCUMENT_NUMBER.
         */
        String DOCUMENT_NUMBER = "numero documento";
    }

    /**
     * The interface Tool bar type.
     */
    public interface ToolBarType
    {
        /**
         * The constant SIMPLE_TOOLBAR.
         */
        int SIMPLE_TOOLBAR = 1;
        /**
         * The constant SIMPLE_TOOLBAR.
         */
        int BACK_TOOLBAR = 2;
        /**
         * The constant NO_TOOLBAR.
         */
        int NO_TOOLBAR = 3;
        /**
         * The constant NO_TOOLBAR.
         */
        int NAVIGATION_DRAWER = 4;

    }

    /**
     * The interface splash
     */
    public interface Splash
    {
        /**
         * The constant SPLASH_SCREEN_DELAY
         * .
         */
        int SPLASH_SCREEN_DELAY = 5000;

    }

    /**
     * The interface ExtrasKeys
     */
    public interface ExtrasKeys
    {
        /**
         * The constant SELECTED_OPTION.
         */
        String SELECTED_OPTION = "selectedOption";
    }


    /**
     * The interface Urlservices.
     */
    public interface URLSERVICES
    {
        /**
         * The constant CONSULTA_SERVICIO_NO_EXISTE.
         */
        String CONSULTA_SERVICIO_URL = "http://10.201.1.13:";
        /**
         * The constant COMPLEMENTO.
         */
        String COMPLEMENTO = "/api/prospect/";

    }

    /**
     * The interface Cod response webservice.
     */
    public interface CodResponseWebservice
    {
        /**
         * The constant STATUS_CODE.
         */
        String STATUS_CODE = "statuscode";
        /**
         * The constant RESPONSE_NOOK.
         */
        int RESPONSE_NOOK = 201;
        /**
         * The constant RESPONSE_OK.
         */
        int RESPONSE_OK = 200;

    }

    /**
     * The interface Chars.
     */
    public interface ErrorType
    {
        int FAIL_CONNECTION_NO_EXIST = 15;
    }
}

