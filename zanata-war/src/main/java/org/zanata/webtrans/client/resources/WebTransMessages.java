package org.zanata.webtrans.client.resources;

import com.google.gwt.i18n.client.LocalizableResource.DefaultLocale;
import com.google.gwt.i18n.client.LocalizableResource.Generate;
import com.google.gwt.i18n.client.Messages;

@DefaultLocale
@Generate(format = "com.google.gwt.i18n.rebind.format.PropertiesFormat")
public interface WebTransMessages extends Messages
{

   @DefaultMessage("{0} participants")
   @AlternateMessage({ "one", "One participant" })
   @Description("Title of the minimized users panel")
   String nUsersOnline(@PluralCount int numUsers);

   @DefaultMessage("(No Content)")
   String noContent();

   @DefaultMessage("{0}% ({1,number,#.#}hrs)")
   String statusBarPercentageHrs(int approved, double remainingHours);

   @DefaultMessage("{0,number,#.#}")
   String statusBarLabelHours(double remainingHours);

   @DefaultMessage("{0}%")
   String statusBarLabelPercentage(int approved);

   @DefaultMessage("http://zanata.org/")
   String hrefHelpLink();

   @DefaultMessage("{0} to {1} - Zanata Web Translation")
   String windowTitle(String workspaceName, String localeName);

   @DefaultMessage("First Page")
   String firstPage();

   @DefaultMessage("Home")
   String firstPageShortcut();

   @DefaultMessage("Previous Page")
   String prevPage();

   @DefaultMessage("PageUp")
   String prevPageShortcut();

   @DefaultMessage("Next Page")
   String nextPage();

   @DefaultMessage("PageDown")
   String nextPageShortcut();

   @DefaultMessage("Last Page")
   String lastPage();

   @DefaultMessage("End")
   String lastPageShortcut();

   @DefaultMessage("Show Translation Suggestions")
   String showTranslationMemoryPanel();

   @DefaultMessage("Show Editor Options")
   String showEditorOptions();

   @DefaultMessage("Hide Editor Options")
   String hideEditorOptions();

   @DefaultMessage("► Options")
   String showEditorOptionsLabel();

   @DefaultMessage("◄ Options")
   String hideEditorOptionsLabel();

   @DefaultMessage("▼ Minimise")
   String minimiseLabel();

   @DefaultMessage("▲ Restore")
   String restoreLabel();

   @DefaultMessage("Find")
   String findButton();

   @DefaultMessage("Find Messages")
   String transUnitSearchesHeading();

   @DefaultMessage("Translation Unit Details")
   String transUnitDetailsHeading();

   @DefaultMessage("Translation Memory/Glossary")
   String tmGlossaryHeading();

   @DefaultMessage("Validation Details")
   String validationDetailsHeading();

   @DefaultMessage("Source or Target content")
   String findSourceOrTargetString();

   @DefaultMessage("{0} (Shortcut: {1})")
   String tooltipsWithShortcut(String text, String shortcut);

   @DefaultMessage("Loading")
   String loading();

   @DefaultMessage("Failed to load document from Server")
   String loadDocFailed();

   @DefaultMessage("Directory")
   String columnHeaderDirectory();

   @DefaultMessage("Document")
   String columnHeaderDocument();

   @DefaultMessage("Statistic")
   String columnHeaderStatistic();

   @DefaultMessage("Translated words")
   String columnHeaderTranslated();

   @DefaultMessage("Untranslated words")
   String columnHeaderUntranslated();

   @DefaultMessage("Remaining hours")
   String columnHeaderRemaining();

   @DefaultMessage("No document selected")
   String noDocumentSelected();

   @DefaultMessage("Project-wide Search and Replace")
   String projectWideSearchAndReplace();

   @DefaultMessage("has quit workspace")
   String hasQuitWorkspace();

   @DefaultMessage("has joined workspace")
   String hasJoinedWorkspace();

   @DefaultMessage("Searching")
   String searching();

   @DefaultMessage("Search found results in {0} documents")
   @AlternateMessage({ "one", "Search found results in 1 document" })
   String searchFoundResultsInDocuments(@PluralCount int numDocs);

   @DefaultMessage("There are no search results to display")
   String noSearchResults();

   @DefaultMessage("Search failed")
   String searchFailed();

   @DefaultMessage("Preview")
   String fetchPreview();

   @DefaultMessage("Previewing")
   String fetchingPreview();

   @DefaultMessage("Fetched preview")
   String fetchedPreview();

   @DefaultMessage("Failed to fetch preview")
   String previewFailed();

   @DefaultMessage("Replace")
   String replace();

   @DefaultMessage("Replacing")
   String replacing();

   @DefaultMessage("Replaced")
   String replaced();

   @DefaultMessage("Replaced \"{0}\" with \"{1}\" in {2} text flows")
   @AlternateMessage({ "one", "Replaced \"{0}\" with \"{1}\" in 1 text flow" })
   String replacedTextInMultipleTextFlows(String searchText, String replacement, @PluralCount int numFlows);

   @DefaultMessage("Successfully replaced text")
   String replacedTextSuccess();

   @DefaultMessage("View in editor")
   String viewDocInEditor();

   @DefaultMessage("Show this document in editor view")
   String viewDocInEditorDetailed();

   @DefaultMessage("Search document in editor")
   String searchDocInEditor();

   @DefaultMessage("Show this document in the editor with the current search active")
   String searchDocInEditorDetailed();

   @DefaultMessage("Index")
   String rowIndex();

   @DefaultMessage("Source")
   String source();

   @DefaultMessage("Target")
   String target();

   @DefaultMessage("Actions")
   String actions();

   @DefaultMessage("Replace text failed")
   String replaceTextFailure();

   @DefaultMessage("Undo")
   String undo();

   @DefaultMessage("Undoing")
   String undoInProgress();

   @DefaultMessage("Undo replacement failed")
   String undoReplacementFailure();

   @DefaultMessage("Undo successful")
   String undoSuccess();

   @DefaultMessage("Select entire document")
   String selectAllInDocument();

   @DefaultMessage("Select or deselect all matching text flows in this document")
   String selectAllInDocumentDetailed();

   @DefaultMessage("Nothing selected")
   String noTextFlowsSelected();

   @DefaultMessage("Help")
   String help();

   @DefaultMessage("Leave Workspace")
   String leaveWorkspace();

   @DefaultMessage("Sign Out")
   String signOut();

   @DefaultMessage("Search and replace")
   String searchAndReplace();
   
   @DefaultMessage("▼")
   String downArrow();

   @DefaultMessage("Notification")
   String notification();
}
