package com.odaniel.practica.Models.RedditJson;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by odiaz on 31/01/2017.
 */
public class Data implements Parcelable {
    @SerializedName("suggested_comment_sort")
    private String suggested_comment_sort;

    @SerializedName("description_html")
    private String description_html;

    @SerializedName("submit_text_html")
    private String submit_text_html;

    @SerializedName("quarantine")
    private String quarantine;

    @SerializedName("public_traffic")
    private String public_traffic;

    @SerializedName("comment_score_hide_mins")
    private String comment_score_hide_mins;

    @SerializedName("user_is_banned")
    private String user_is_banned;

    @SerializedName("created_utc")
    private String created_utc;

    @SerializedName("user_is_moderator")
    private String user_is_moderator;

    @SerializedName("lang")
    private String lang;

    @SerializedName("user_sr_theme_enabled")
    private String user_sr_theme_enabled;

    @SerializedName("public_description")
    private String public_description;

    @SerializedName("submit_text_label")
    private String submit_text_label;

    @SerializedName("id")
    private String id;

    @SerializedName("banner_size")
    private List<String> banner_size;

    @SerializedName("key_color")
    private String key_color;

    @SerializedName("title")
    private String title;

    @SerializedName("spoilers_enabled")
    private String spoilers_enabled;

    @SerializedName("created")
    private String created;

    @SerializedName("header_img")
    private String header_img;

    @SerializedName("submit_text")
    private String submit_text;

    @SerializedName("subreddit_type")
    private String subreddit_type;

    @SerializedName("description")
    private String description;

    @SerializedName("name")
    private String name;

    @SerializedName("banner_img")
    private String banner_img;

    @SerializedName("accounts_active")
    private String accounts_active;

    @SerializedName("over18")
    private String over18;

    @SerializedName("collapse_deleted_comments")
    private String collapse_deleted_comments;

    @SerializedName("user_is_subscriber")
    private String user_is_subscriber;

    @SerializedName("submit_link_label")
    private String submit_link_label;

    @SerializedName("icon_size")
    private List<String> icon_size;

    @SerializedName("header_title")
    private String header_title;

    @SerializedName("hide_ads")
    private String hide_ads;

    @SerializedName("submission_type")
    private String submission_type;

    @SerializedName("user_is_contributor")
    private String user_is_contributor;

    @SerializedName("url")
    private String url;

    @SerializedName("display_name")
    private String display_name;

    @SerializedName("wiki_enabled")
    private String wiki_enabled;

    @SerializedName("public_description_html")
    private String public_description_html;

    @SerializedName("icon_img")
    private String icon_img;

    @SerializedName("show_media_preview")
    private String show_media_preview;

    @SerializedName("subscribers")
    private String subscribers;

    @SerializedName("show_media")
    private String show_media;

    @SerializedName("header_size")
    private List<String> header_size;

    @SerializedName("user_is_muted")
    private String user_is_muted;

    public String getSuggested_comment_sort ()
    {
        return suggested_comment_sort;
    }

    public void setSuggested_comment_sort (String suggested_comment_sort)
    {
        this.suggested_comment_sort = suggested_comment_sort;
    }

    public String getDescription_html ()
    {
        return description_html;
    }

    public void setDescription_html (String description_html)
    {
        this.description_html = description_html;
    }

    public String getSubmit_text_html ()
    {
        return submit_text_html;
    }

    public void setSubmit_text_html (String submit_text_html)
    {
        this.submit_text_html = submit_text_html;
    }

    public String getQuarantine ()
    {
        return quarantine;
    }

    public void setQuarantine (String quarantine)
    {
        this.quarantine = quarantine;
    }

    public String getPublic_traffic ()
    {
        return public_traffic;
    }

    public void setPublic_traffic (String public_traffic)
    {
        this.public_traffic = public_traffic;
    }

    public String getComment_score_hide_mins ()
    {
        return comment_score_hide_mins;
    }

    public void setComment_score_hide_mins (String comment_score_hide_mins)
    {
        this.comment_score_hide_mins = comment_score_hide_mins;
    }

    public String getUser_is_banned ()
    {
        return user_is_banned;
    }

    public void setUser_is_banned (String user_is_banned)
    {
        this.user_is_banned = user_is_banned;
    }

    public String getCreated_utc ()
    {
        return created_utc;
    }

    public void setCreated_utc (String created_utc)
    {
        this.created_utc = created_utc;
    }

    public String getUser_is_moderator ()
    {
        return user_is_moderator;
    }

    public void setUser_is_moderator (String user_is_moderator)
    {
        this.user_is_moderator = user_is_moderator;
    }

    public String getLang ()
    {
        return lang;
    }

    public void setLang (String lang)
    {
        this.lang = lang;
    }

    public String getUser_sr_theme_enabled ()
    {
        return user_sr_theme_enabled;
    }

    public void setUser_sr_theme_enabled (String user_sr_theme_enabled)
    {
        this.user_sr_theme_enabled = user_sr_theme_enabled;
    }

    public String getPublic_description ()
    {
        return public_description;
    }

    public void setPublic_description (String public_description)
    {
        this.public_description = public_description;
    }

    public String getSubmit_text_label ()
    {
        return submit_text_label;
    }

    public void setSubmit_text_label (String submit_text_label)
    {
        this.submit_text_label = submit_text_label;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public List<String> getBanner_size ()
    {
        return banner_size;
    }

    public void setBanner_size (List<String> banner_size)
    {
        this.banner_size = banner_size;
    }

    public String getKey_color ()
    {
        return key_color;
    }

    public void setKey_color (String key_color)
    {
        this.key_color = key_color;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getSpoilers_enabled ()
    {
        return spoilers_enabled;
    }

    public void setSpoilers_enabled (String spoilers_enabled)
    {
        this.spoilers_enabled = spoilers_enabled;
    }

    public String getCreated ()
    {
        return created;
    }

    public void setCreated (String created)
    {
        this.created = created;
    }

    public String getHeader_img ()
    {
        return header_img;
    }

    public void setHeader_img (String header_img)
    {
        this.header_img = header_img;
    }

    public String getSubmit_text ()
    {
        return submit_text;
    }

    public void setSubmit_text (String submit_text)
    {
        this.submit_text = submit_text;
    }

    public String getSubreddit_type ()
    {
        return subreddit_type;
    }

    public void setSubreddit_type (String subreddit_type)
    {
        this.subreddit_type = subreddit_type;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getBanner_img ()
    {
        return banner_img;
    }

    public void setBanner_img (String banner_img)
    {
        this.banner_img = banner_img;
    }

    public String getAccounts_active ()
    {
        return accounts_active;
    }

    public void setAccounts_active (String accounts_active)
    {
        this.accounts_active = accounts_active;
    }

    public String getOver18 ()
    {
        return over18;
    }

    public void setOver18 (String over18)
    {
        this.over18 = over18;
    }

    public String getCollapse_deleted_comments ()
    {
        return collapse_deleted_comments;
    }

    public void setCollapse_deleted_comments (String collapse_deleted_comments)
    {
        this.collapse_deleted_comments = collapse_deleted_comments;
    }

    public String getUser_is_subscriber ()
    {
        return user_is_subscriber;
    }

    public void setUser_is_subscriber (String user_is_subscriber)
    {
        this.user_is_subscriber = user_is_subscriber;
    }

    public String getSubmit_link_label ()
    {
        return submit_link_label;
    }

    public void setSubmit_link_label (String submit_link_label)
    {
        this.submit_link_label = submit_link_label;
    }

    public List<String> getIcon_size ()
    {
        return icon_size;
    }

    public void setIcon_size (List<String> icon_size)
    {
        this.icon_size = icon_size;
    }

    public String getHeader_title ()
    {
        return header_title;
    }

    public void setHeader_title (String header_title)
    {
        this.header_title = header_title;
    }

    public String getHide_ads ()
    {
        return hide_ads;
    }

    public void setHide_ads (String hide_ads)
    {
        this.hide_ads = hide_ads;
    }

    public String getSubmission_type ()
    {
        return submission_type;
    }

    public void setSubmission_type (String submission_type)
    {
        this.submission_type = submission_type;
    }

    public String getUser_is_contributor ()
    {
        return user_is_contributor;
    }

    public void setUser_is_contributor (String user_is_contributor)
    {
        this.user_is_contributor = user_is_contributor;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public String getDisplay_name ()
    {
        return display_name;
    }

    public void setDisplay_name (String display_name)
    {
        this.display_name = display_name;
    }

    public String getWiki_enabled ()
    {
        return wiki_enabled;
    }

    public void setWiki_enabled (String wiki_enabled)
    {
        this.wiki_enabled = wiki_enabled;
    }

    public String getPublic_description_html ()
    {
        return public_description_html;
    }

    public void setPublic_description_html (String public_description_html)
    {
        this.public_description_html = public_description_html;
    }

    public String getIcon_img ()
    {
        return icon_img;
    }

    public void setIcon_img (String icon_img)
    {
        this.icon_img = icon_img;
    }

    public String getShow_media_preview ()
    {
        return show_media_preview;
    }

    public void setShow_media_preview (String show_media_preview)
    {
        this.show_media_preview = show_media_preview;
    }

    public String getSubscribers ()
    {
        return subscribers;
    }

    public void setSubscribers (String subscribers)
    {
        this.subscribers = subscribers;
    }

    public String getShow_media ()
    {
        return show_media;
    }

    public void setShow_media (String show_media)
    {
        this.show_media = show_media;
    }

    public List<String> getHeader_size ()
    {
        return header_size;
    }

    public void setHeader_size (List<String> header_size)
    {
        this.header_size = header_size;
    }

    public String getUser_is_muted ()
    {
        return user_is_muted;
    }

    public void setUser_is_muted (String user_is_muted)
    {
        this.user_is_muted = user_is_muted;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [suggested_comment_sort = "+suggested_comment_sort+", description_html = "+description_html+", submit_text_html = "+submit_text_html+", quarantine = "+quarantine+", public_traffic = "+public_traffic+", comment_score_hide_mins = "+comment_score_hide_mins+", user_is_banned = "+user_is_banned+", created_utc = "+created_utc+", user_is_moderator = "+user_is_moderator+", lang = "+lang+", user_sr_theme_enabled = "+user_sr_theme_enabled+", public_description = "+public_description+", submit_text_label = "+submit_text_label+", id = "+id+", banner_size = "+banner_size+", key_color = "+key_color+", title = "+title+", spoilers_enabled = "+spoilers_enabled+", created = "+created+", header_img = "+header_img+", submit_text = "+submit_text+", subreddit_type = "+subreddit_type+", description = "+description+", name = "+name+", banner_img = "+banner_img+", accounts_active = "+accounts_active+", over18 = "+over18+", collapse_deleted_comments = "+collapse_deleted_comments+", user_is_subscriber = "+user_is_subscriber+", submit_link_label = "+submit_link_label+", icon_size = "+icon_size+", header_title = "+header_title+", hide_ads = "+hide_ads+", submission_type = "+submission_type+", user_is_contributor = "+user_is_contributor+", url = "+url+", display_name = "+display_name+", wiki_enabled = "+wiki_enabled+", public_description_html = "+public_description_html+", icon_img = "+icon_img+", show_media_preview = "+show_media_preview+", subscribers = "+subscribers+", show_media = "+show_media+", header_size = "+header_size+", user_is_muted = "+user_is_muted+"]";
    }

    protected Data(Parcel in) {
        suggested_comment_sort = in.readString();
        description_html = in.readString();
        submit_text_html = in.readString();
        quarantine = in.readString();
        public_traffic = in.readString();
        comment_score_hide_mins = in.readString();
        user_is_banned = in.readString();
        created_utc = in.readString();
        user_is_moderator = in.readString();
        lang = in.readString();
        user_sr_theme_enabled = in.readString();
        public_description = in.readString();
        submit_text_label = in.readString();
        id = in.readString();
        key_color = in.readString();
        title = in.readString();
        spoilers_enabled = in.readString();
        created = in.readString();
        header_img = in.readString();
        submit_text = in.readString();
        subreddit_type = in.readString();
        description = in.readString();
        name = in.readString();
        banner_img = in.readString();
        accounts_active = in.readString();
        over18 = in.readString();
        collapse_deleted_comments = in.readString();
        user_is_subscriber = in.readString();
        submit_link_label = in.readString();
        header_title = in.readString();
        hide_ads = in.readString();
        submission_type = in.readString();
        user_is_contributor = in.readString();
        url = in.readString();
        display_name = in.readString();
        wiki_enabled = in.readString();
        public_description_html = in.readString();
        icon_img = in.readString();
        show_media_preview = in.readString();
        subscribers = in.readString();
        show_media = in.readString();
        user_is_muted = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(suggested_comment_sort);
        dest.writeString(description_html);
        dest.writeString(submit_text_html);
        dest.writeString(quarantine);
        dest.writeString(public_traffic);
        dest.writeString(comment_score_hide_mins);
        dest.writeString(user_is_banned);
        dest.writeString(created_utc);
        dest.writeString(user_is_moderator);
        dest.writeString(lang);
        dest.writeString(user_sr_theme_enabled);
        dest.writeString(public_description);
        dest.writeString(submit_text_label);
        dest.writeString(id);
        dest.writeString(key_color);
        dest.writeString(title);
        dest.writeString(spoilers_enabled);
        dest.writeString(created);
        dest.writeString(header_img);
        dest.writeString(submit_text);
        dest.writeString(subreddit_type);
        dest.writeString(description);
        dest.writeString(name);
        dest.writeString(banner_img);
        dest.writeString(accounts_active);
        dest.writeString(over18);
        dest.writeString(collapse_deleted_comments);
        dest.writeString(user_is_subscriber);
        dest.writeString(submit_link_label);
        dest.writeString(header_title);
        dest.writeString(hide_ads);
        dest.writeString(submission_type);
        dest.writeString(user_is_contributor);
        dest.writeString(url);
        dest.writeString(display_name);
        dest.writeString(wiki_enabled);
        dest.writeString(public_description_html);
        dest.writeString(icon_img);
        dest.writeString(show_media_preview);
        dest.writeString(subscribers);
        dest.writeString(show_media);
        dest.writeString(user_is_muted);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Data> CREATOR = new Parcelable.Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };
}