package net.sehales.ts3_japi.wrapper;

import java.math.BigInteger;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import net.sehales.ts3_japi.property.HostMessageMode;

public class ServerInfo extends Server {
    protected IntegerProperty                 antifloodPointsTickReduce              = new SimpleIntegerProperty();
    protected StringProperty                  version                                = new SimpleStringProperty();
    protected BooleanProperty                 password                               = new SimpleBooleanProperty();
    protected LongProperty                    keepalivePacketsReceived               = new SimpleLongProperty();
    protected IntegerProperty                 defaultChannelAdminGroup               = new SimpleIntegerProperty();
    protected BooleanProperty                 loggingQuery                           = new SimpleBooleanProperty();
    protected LongProperty                    totalKeepalivePacketloss               = new SimpleLongProperty();
    protected IntegerProperty                 prioritySpeakerDimmModificator         = new SimpleIntegerProperty();
    protected IntegerProperty                 neededSecurityLevel                    = new SimpleIntegerProperty();
    protected IntegerProperty                 channelCount                           = new SimpleIntegerProperty();
    protected LongProperty                    controlPacketsReceived                 = new SimpleLongProperty();
    protected StringProperty                  platform                               = new SimpleStringProperty();
    protected LongProperty                    filetransferBandwidthReceived          = new SimpleLongProperty();
    protected StringProperty                  welcomeMessage                         = new SimpleStringProperty();
    protected IntegerProperty                 complainRemoveTime                     = new SimpleIntegerProperty();
    protected LongProperty                    totalBytesReceived                     = new SimpleLongProperty();
    protected IntegerProperty                 antifloodPointsNeededIPBlock           = new SimpleIntegerProperty();
    protected LongProperty                    totalBytesUploaded                     = new SimpleLongProperty();
    protected LongProperty                    bytesReceivedSpeech                    = new SimpleLongProperty();
    protected LongProperty                    packetsReceivedTotal                   = new SimpleLongProperty();
    protected IntegerProperty                 complainAutobanCount                   = new SimpleIntegerProperty();
    protected IntegerProperty                 iconId                                 = new SimpleIntegerProperty();
    protected LongProperty                    bytesSentTotal                         = new SimpleLongProperty();
    protected LongProperty                    bytesSentControl                       = new SimpleLongProperty();
    protected ObjectProperty<BigInteger>      maxDownloadTotalBandwidth              = new SimpleObjectProperty<>();
    protected FloatProperty                   totalPing                              = new SimpleFloatProperty();
    protected ObjectProperty<HostMessageMode> hostmessageMode                        = new SimpleObjectProperty<>();
    protected LongProperty                    monthBytesDownloaded                   = new SimpleLongProperty();
    protected IntegerProperty                 minClientsInChannelBeforeForcedSilence = new SimpleIntegerProperty();
    protected ObjectProperty<BigInteger>      bytesReceivedKeepalive                 = new SimpleObjectProperty<>();
    protected IntegerProperty                 antiFloodPointsNeededCommandBlock      = new SimpleIntegerProperty();
    protected BooleanProperty                 logChannel                             = new SimpleBooleanProperty();
    protected FloatProperty                   totalPacketloss                        = new SimpleFloatProperty();
    protected IntegerProperty                 reservedSlots                          = new SimpleIntegerProperty();
    protected BooleanProperty                 logServer                              = new SimpleBooleanProperty();
    protected StringProperty                  created                                = new SimpleStringProperty();
    protected IntegerProperty                 queryClientConnections                 = new SimpleIntegerProperty();
    protected IntegerProperty                 minClientVersion                       = new SimpleIntegerProperty();
    protected LongProperty                    totalBytesDownloaded                   = new SimpleLongProperty();
    protected LongProperty                    bytesSentKeepalive                     = new SimpleLongProperty();
    protected BooleanProperty                 logClient                              = new SimpleBooleanProperty();

    /*
     * TODO
     * virtualserver_download_quota = 18446744073709551615
     * connection_filetransfer_bytes_received_total = 0
     * connection_packets_sent_keepalive = 0
     * virtualserver_filebase = files\virtualserver_2
     * virtualserver_channel_temp_delete_delay_default = 0
     * virtualserver_weblist_enabled = 1
     * virtualserver_max_upload_total_bandwidth = 18446744073709551615
     * virtualserver_complain_autoban_time = 1200
     * virtualserver_codec_encryption_mode = 0
     * connection_filetransfer_bytes_sent_total = 0
     * connection_packets_sent_total = 0
     * virtualserver_log_permissions = 1
     * virtualserver_total_packetloss_speech = 0.0000
     * virtualserver_month_bytes_uploaded = 0
     * connection_packets_received_speech = 0
     * virtualserver_default_channel_group = 76
     * connection_bandwidth_sent_last_minute_total = 0
     * virtualserver_upload_quota = 18446744073709551615
     * connection_filetransfer_bandwidth_sent = 0
     * connection_bytes_sent_speech = 0
     * virtualserver_hostbanner_mode = 0
     * virtualserver_total_packetloss_control = 0.0000
     * virtualserver_ask_for_privilegekey = 0
     * virtualserver_log_filetransfer = 1
     * connection_bandwidth_received_last_minute_total = 0
     * virtualserver_default_server_group = 1585
     * connection_packets_sent_speech = 0
     * connection_bytes_received_control = 0
     * connection_packets_sent_control = 0
     * virtualserver_hostbanner_gfx_interval = 0
     * virtualserver_client_connections = 0
     * connection_bandwidth_sent_last_second_total = 0
     * connection_bandwidth_received_last_second_total = 0
     */
    public ServerInfo(MapWrapper serverWrapper) {
        super(serverWrapper);
    }

}
