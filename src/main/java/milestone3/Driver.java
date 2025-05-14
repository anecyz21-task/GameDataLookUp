package milestone3;

import java.math.BigDecimal;
import java.util.Currency;
import milestone3.dal.*;
import milestone3.model.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import milestone3.model.BodySlot.PositionName;
import milestone3.model.Character;
import milestone3.model.Clan.RaceName;
import milestone3.model.ConsumableBonus.BonusName;
import milestone3.model.Statistic.StatisticName;

public class Driver {
  public static void main(String[] args) {
    try {
      resetSchema();
      insertRecords();
    } catch (SQLException e) {
      System.out.print("SQL Exception: ");
      System.out.println(e.getMessage());
      e.printStackTrace();
      System.exit(-1);
    }
  }

  public static void insertRecords() throws SQLException {
    try (
      Connection cxn = ConnectionManager.getConnection()
    ) {
      // INSERT objects from our model.
      System.out.println("Milestone4 method calling");
      System.out.println("INSERT");

      Clan clan1 = ClanDao.create(cxn, "ClanName1", RaceName.Human);
      Player player1 = PlayerDao.create(cxn, "email1", "PlayerFirst1",  "PlayerLast1");
      Character character1 = CharacterDao.create(cxn, "email1", "FirstName1", "LastName1", "ClanName1");
      Currencies currency1 = CurrenciesDao.create(cxn, "CurrencyName1", 9999, 9999);
      CharacterCurrencies characterCurrencies1 = CharacterCurrenciesDao.createCharacterCurrencies(cxn, 1, 1, 10, 10);
      JobType jobType1 = JobTypeDao.createJobType(cxn, "JobName1");
      CharacterJob characterJob1 = CharacterJobDao.createCharacterJob(cxn, 1, 1, 10, 1, false);
      Statistic statistic1 = StatisticDao.create(cxn, StatisticName.Strength, 1, 10);
      StatisticDao.create(cxn, StatisticName.Dexterity, 1, 10);
      StatisticDao.create(cxn, StatisticName.Magic, 1, 10);
      StatisticDao.create(cxn, StatisticName.Spirit, 1, 10);
      StatisticDao.create(cxn, StatisticName.Vitality, 1, 10);
      Item item1 = ItemDao.create(cxn, "ItemName1", 1, 10, 2.0);
      BodySlot bodySlot1 = BodySlotDao.create(cxn, 1, PositionName.Head, 1);
      Consumable consumable1 = ConsumableDao.create(cxn, "ConsumableName1", 2, 20, 3, "Consumable description 1");
      ConsumableBonus consumableBonus1 = ConsumableBonusDao.create(cxn, 2, ConsumableBonus.BonusName.Strength, new BigDecimal(0.5), 10);
      Weapon weapon1 = WeaponDao.create(cxn, "WeaponName1", 3, 99, 4.5, 1, 1, 10);
      Gear gear1 = GearDao.create(cxn, "GearName1",  4, 999, 5.99, 1);
      Inventory inventory1 = InventoryDao.create(cxn, 1, 1, 1, 1);
      GearJob gear1job = GearJobDao.createGearJob(cxn, 3, 1);
      GearWeaponBonus gearWeaponBonus1 = GearWeaponBonusDao.create(cxn, 3, GearWeaponBonus.BonusName.Strength, new BigDecimal(0.5));
      
      // Creating Clan records
      for (int i = 2; i <= 10; i++) {
        Clan clan = ClanDao.create(cxn, "ClanName" + i, RaceName.values()[i % RaceName.values().length]);
      }

      // Creating Player records
      for (int i = 1; i <= 3; i++) {
        Player player = PlayerDao.create(cxn, "email" + i + "@domain.com", "PlayerFirst" + i, "PlayerLast" + i);
      }

      // Creating Character records
      for (int i = 2; i <= 10; i++) {
        Character character = CharacterDao.create(cxn, "email" + (i % 3 + 1) + "@domain.com", "FirstName" + i, "LastName" + i, "ClanName" + (i % 5 + 1));
      }

      // Creating Currency records
      for (int i = 2; i <= 10; i++) {
        Currencies currency = CurrenciesDao.create(cxn, "CurrencyName" + i, 1000 * i, 500 * i);
      }

      // Creating CharacterCurrencies records
      for (int i = 2; i <= 10; i++) {
        CharacterCurrencies characterCurrencies = CharacterCurrenciesDao.createCharacterCurrencies(cxn, i, i, 10 + i, 20 + i);
      }

      // Creating JobType records
      for (int i = 2; i <= 10; i++) {
        JobType jobType = JobTypeDao.createJobType(cxn, "JobName" + i);
      }

      // Creating CharacterJob records
      for (int i = 2; i <= 10; i++) {
        CharacterJob characterJob = CharacterJobDao.createCharacterJob(cxn, i, i, 100 + i, 10 + i, false);
      }

      // Creating Statistic records
      for (int i = 0; i <= 4; i++) {
      	for (int j = 2; j <= 10; j++) {
          Statistic statistic = StatisticDao.create(cxn, StatisticName.values()[i], (j), 100 + i);
//          statistic = StatisticDao.create(cxn, StatisticName.values()[i], (j), 100 + i);
//          statistic = StatisticDao.create(cxn, StatisticName.values()[i], (j), 100 + i);
//          statistic = StatisticDao.create(cxn, StatisticName.values()[i], (j), 100 + i);
//          statistic = StatisticDao.create(cxn, StatisticName.values()[i], (j), 100 + i);
      	}
      }

      // Creating Item records
      for (int i = 2; i <= 10; i++) {
        Item item = ItemDao.create(cxn, "ItemName" + i, i, 50 + i, 1.5 + i * 0.5);
      }

      // Creating BodySlot records
      for (int i = 2; i <= 10; i++) {
        BodySlot bodySlot = BodySlotDao.create(cxn, i, PositionName.values()[i % PositionName.values().length], i);
      }

      // Creating Consumable records
      for (int i = 2; i <= 10; i++) {
        Consumable consumable = ConsumableDao.create(cxn, "ConsumableName" + i, 5 + i, 50 + i * 2, 3 + i, "Consumable description " + i);
      }

      // Creating ConsumableBonus records
      for (int i = 14; i <= 22; i++) {
      	System.out.println(i);
        ConsumableBonus consumableBonus = ConsumableBonusDao.create(cxn, i, ConsumableBonus.BonusName.values()[i % ConsumableBonus.BonusName.values().length], new BigDecimal(0.5 + i * 0.1), 10 * i);
      }

      // Creating Weapon records
      for (int i = 2; i <= 10; i++) {
        Weapon weapon = WeaponDao.create(cxn, "WeaponName" + i, 10 + i, 200 + i * 10, 4.5 + i * 0.5, 1, 2, 50 + i);
      }

      // Creating Gear records
      for (int i = 2; i <= 10; i++) {
        Gear gear = GearDao.create(cxn, "GearName" + i, 5 + i, 1000 + i * 100, 10.0 + i, 1);
      }

      // Creating Inventory records
      for (int i = 2; i <= 10; i++) {
        Inventory inventory = InventoryDao.create(cxn, i, i, 5 + i, 2 + i);
      }

      // Creating GearJob records
      for (int i = 2; i <= 10; i++) {
        GearJob gearJob = GearJobDao.createGearJob(cxn, 21 + i, i);
      }

      // Creating GearWeaponBonus records
      for (int i = 2; i <= 10; i++) {
        GearWeaponBonus gearWeaponBonus = GearWeaponBonusDao.create(cxn, 21 + i, GearWeaponBonus.BonusName.values()[i % GearWeaponBonus.BonusName.values().length], new BigDecimal(0.5 + i * 0.1));
      }

      // Retrieval
      System.out.println("Retrieval");
      BodySlot bs1 = BodySlotDao.getBodySlotByPK(cxn, 1, PositionName.Head);
      System.out.format("Reading BodySlot: characterId:%d positionName:%s itemID:%d \n", bs1.getCharacterId(), bs1.getPositionName().name(),  bs1.getItemID());

      CharacterCurrencies cc1 = CharacterCurrenciesDao.getCharacterCurrenciesByID(cxn, 1, 1);
      System.out.format("CharacterCurrencies - characterId: %d, currencyID int: %d, amountOwned: %d, amountAcquiredWeekly: %d\n",
          cc1.getCharacterID(), cc1.getCurrencyID(), cc1.getAmountOwned(), cc1.getAmountAcquiredWeekly());

      Character c1 = CharacterDao.getCharacterById(cxn, 1);
      System.out.println(c1.toString());

      CharacterJob cj1 = CharacterJobDao.getCharacterJobByID(cxn, 1, 1);
      System.out.println(cj1.toString());

      Clan cl1 = ClanDao.getClanByName(cxn, "clanName1");
      System.out.println(cl1.toString());

      ConsumableBonus cb1 = ConsumableBonusDao.getConsumableBonusByPK(cxn, 2, BonusName.Strength);
      System.out.println(cb1.toString());

      Consumable cs1 = ConsumableDao.getConsumableById(cxn, 2);
      System.out.println(cs1.toString());

      ConsumableDao.updateDescription(cxn, consumable1, "new description");
      System.out.println(consumable1.toString());

      Currencies cy1 = CurrenciesDao.getCurrencyByID(cxn, 1);
      System.out.println(cy1.toString());

      Gear ge1 = GearDao.getGearById(cxn, 3);
      System.out.println(ge1.toString());

      List<Gear> gears = GearDao.getGearByName(cxn, "gearName1");
      for (Gear gear : gears) {
        System.out.println(gear.toString());
      }

      GearJob gj1 = GearJobDao.getGearJobByID(cxn, 3, 1);
      System.out.println(gj1.toString());

      GearWeaponBonus gwb1 = GearWeaponBonusDao.getGearWeaponBonusByPK(cxn, 3, GearWeaponBonus.BonusName.Strength);
      System.out.println(gwb1.toString());

      Inventory i1 = InventoryDao.getInventoryByPK(cxn, 1, 1);
      System.out.println(i1.toString());

      Item it1 = ItemDao.getItemById(cxn, 1);
      System.out.println(it1.toString());

      JobType jt1 = JobTypeDao.getJobTypeByID(cxn, 1);
      System.out.println(jt1.toString());

      Player p1 = PlayerDao.getPlayerByEmail(cxn, "email1");
      System.out.println(p1.toString());

      PlayerDao.create(cxn, "email2", "playfirst2",  "playerlast2");
      PlayerDao.deleteByEmail(cxn, "email2");

      Statistic s1 = StatisticDao.getByNameAndCharacterId(cxn, StatisticName.Strength, 1);
      System.out.println(s1.toString());

      Weapon w1 = WeaponDao.getWeaponById(cxn, 3);
      System.out.println(w1.toString());
    }
  }

  private static void resetSchema() throws SQLException{
    try (
      Connection cxn = ConnectionManager.getSchemalessConnection()
    ) {
      cxn.createStatement().executeUpdate(
        "DROP SCHEMA IF EXISTS PM4;"
      );
      cxn.createStatement().executeUpdate("CREATE SCHEMA PM4;");
    }

    try (
      Connection cxn = ConnectionManager.getConnection()
    ) {
      cxn.createStatement().executeUpdate("""
        create table Player (
        	email varchar(255) primary key,
          firstName varchar(255) not null,
          lastName varchar(255) not null
        );"""
      );

      cxn.createStatement().executeUpdate("""
        create table Clan (
          clanName varchar(255) primary key,
          raceName ENUM ('Human', 'Cat', 'Elf', 'Halfling', 'Dragon')
        );"""
      );

      cxn.createStatement().executeUpdate("""
          create table `Character` (
        	characterId int auto_increment primary key,
            email varchar(255) not null,
            firstName varchar(255) not null,
            lastName varchar(255) not null,
            clanName varchar(255) not null,
            constraint unique_name Unique (firstName, lastname),
            constraint fk_Character_email foreign key (email)
        		references Player(email) on update cascade,
            constraint fk_Character_clanName foreign key (clanName)
        		references Clan(clanName) on update cascade
        );"""
      );

      cxn.createStatement().executeUpdate("""
          create table Statistic (
        	statisticName ENUM ('Strength', 'Dexterity', 'Magic', 'Spirit', 'Vitality'),
            characterId int,
            `value` int  not null,
            constraint pk_Statistic_statisticName_characterId
        		primary key (statisticName, characterId),
            constraint fk_Statistic_characterId foreign key (characterId)
        		references `Character`(characterId) on update cascade
        );"""
      );

      cxn.createStatement().executeUpdate("""
          create table Currencies (
        	currencyID int auto_increment primary key,
            currencyName varchar(255) not null unique,
            cap int,
            weeklyCap int
        );"""
      );

      cxn.createStatement().executeUpdate("""
        create table CharacterCurrencies (
          characterId int,
            currencyID int,
            amountOwned int not null,
            amountAcquiredWeekly int not null,
            constraint pk_CharacterCurrencies_characterId_currencyID
            primary key (characterId, currencyID),
            constraint fk_CharacterCurrencies_characterId foreign key (characterId) 
            references `Character` (characterId) on update cascade on delete cascade,
          constraint fk_Currencies_currencyID foreign key (currencyID) 
            references Currencies (currencyID) on update cascade on delete cascade
        );
      """);

      cxn.createStatement().executeUpdate("""
        create table JobType (
            jobId int auto_increment,
            jobName varchar(255) not null unique,
            constraint pk_JobType_jobId primary key (jobid)
        );
       """);

      cxn.createStatement().executeUpdate("""
        create table CharacterJob (
            characterId int,
            jobId int,
            `level` int not null default 1,
            xp int not null default 0,
            `unlock` boolean not null default false,
            constraint pk_characterjob_characterId_jobId primary key (characterId, jobId),
            constraint fk_characterjob_characterid foreign key (characterId)
                references `Character`(characterId) on delete cascade on update cascade,
            constraint fk_characterjob_jobid foreign key (jobId)
                references JobType(jobId) on delete cascade on update cascade
        );
       """);

      cxn.createStatement().executeUpdate("""
        CREATE TABLE Item (
            itemId INT AUTO_INCREMENT NOT NULL,
            itemName VARCHAR(255) NOT NULL,
            itemLevel INT NOT NULL,
            itemMax INT NOT NULL,
            itemPrice DECIMAL(10,2) NOT NULL,
            CONSTRAINT pk_Item_itemId PRIMARY KEY (itemId)
        );
       """);

      cxn.createStatement().executeUpdate("""
        create table Gear (
            gearId int not null,
            requiredLevel int not null default 1,
            constraint pk_gear_gearId primary key (gearId),
            constraint fk_gear_itemid foreign key (gearId)
                references Item(itemId) on delete cascade on update cascade
        );
       """);

      cxn.createStatement().executeUpdate("""
        create table GearJob (
            gearId int not null,
            jobId int not null,
            constraint pk_gearjob_gearId_jobId primary key (gearId, jobId),
            constraint fk_gearjob_gearid foreign key (gearId)
                references Gear(gearId) on delete cascade on update cascade,
            constraint fk_gearjob_jobid foreign key (jobId)
                references JobType(jobId) on delete cascade on update cascade
        );
       """);

      cxn.createStatement().executeUpdate("""
        create table Weapon (
            weaponId int not null,
            jobId int not null,
            damage int not null,
            constraint pk_weapon primary key (weaponId),
            constraint fk_weapon_gearid foreign key (weaponId)
                references gear(gearId) on delete cascade on update cascade,
            constraint fk_weapon_jobid foreign key (jobId)
                references jobtype(jobId) on delete restrict on update cascade
        );
       """);

      cxn.createStatement().executeUpdate("""
        create table GearWeaponBonus (
            gearId int not null,
            bonusName ENUM ('Strength', 'Dexterity', 'Magic', 'Spirit', 'Vitality'),
            bonusValue decimal(10,2) not null,
            constraint pk_gearweaponbonus primary key (gearId, bonusName),
            constraint fk_gearweaponbonus_gearid foreign key (gearId)
                references Gear(gearId) on delete cascade on update cascade
        );
       """);

      cxn.createStatement().executeUpdate("""
        CREATE TABLE Inventory (
            characterId INT NOT NULL,
            slotId INT NOT NULL,
            itemId INT,
            quantity INT NOT NULL,
            CONSTRAINT pk_Inventory PRIMARY KEY (characterId, slotId),
        	CONSTRAINT fk_Inventory_characterId FOREIGN KEY (characterId)
                REFERENCES `Character`(characterId)
                ON DELETE RESTRICT\s
                ON UPDATE CASCADE,
            CONSTRAINT fk_Inventory_Item FOREIGN KEY (itemId)
                REFERENCES Item(itemId)
                ON DELETE RESTRICT \s
                ON UPDATE CASCADE
        );
       """);

      cxn.createStatement().executeUpdate("""
        CREATE TABLE BodySlot (
            characterId INT NOT NULL,
            positionName ENUM ('Head', 'Feet', 'Arm', 'MainHand', 'RightHand', 'LeftHand'),
            itemID INT NOT NULL,
            CONSTRAINT pk_BodySlot PRIMARY KEY (characterId, positionName),
            CONSTRAINT fk_BodySlot_characterID FOREIGN KEY (characterId)
                REFERENCES `Character`(characterId)
                ON DELETE RESTRICT 
                ON UPDATE CASCADE,
            CONSTRAINT fk_BodySlot_Item FOREIGN KEY (itemId)
                REFERENCES Item(itemId)
                ON DELETE CASCADE
                ON UPDATE CASCADE
        );
       """);

      cxn.createStatement().executeUpdate("""
        CREATE TABLE Consumable (
            consumableId INT NOT NULL,
            `description` TEXT NOT NULL,
            CONSTRAINT pk_Consumable PRIMARY KEY (consumableId),
            CONSTRAINT fk_Consumable_Item FOREIGN KEY (consumableId)
                REFERENCES Item(itemId)
                ON DELETE RESTRICT\s
                ON UPDATE CASCADE
        );
       """);

      cxn.createStatement().executeUpdate("""
        CREATE TABLE ConsumableBonus (
            consumableId INT NOT NULL,
            bonusName ENUM ('Strength', 'Dexterity', 'Magic', 'Spirit', 'Vitality'),
            percentage DECIMAL(5,2) NOT NULL,
            cap INT NOT NULL,
            CONSTRAINT pk_ConsumableBonus PRIMARY KEY (consumableId, bonusName),
            CONSTRAINT fk_ConsumableBonus_Consumable FOREIGN KEY (consumableId)
                REFERENCES Consumable(consumableId)
                ON DELETE RESTRICT
                ON UPDATE CASCADE
        );
       """);
    }
  }
}
